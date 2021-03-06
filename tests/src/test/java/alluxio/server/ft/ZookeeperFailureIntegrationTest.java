/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.server.ft;

import static org.junit.Assert.assertFalse;

import alluxio.ConfigurationRule;
import alluxio.PropertyKey;
import alluxio.grpc.FileSystemMasterClientServiceGrpc;
import alluxio.grpc.ListStatusPRequest;
import alluxio.multi.process.MasterNetAddress;
import alluxio.multi.process.MultiProcessCluster;
import alluxio.multi.process.MultiProcessCluster.DeployMode;
import alluxio.multi.process.PortCoordination;
import alluxio.testutils.AlluxioOperationThread;
import alluxio.testutils.BaseIntegrationTest;
import alluxio.util.CommonUtils;
import alluxio.grpc.GrpcChannel;
import alluxio.grpc.GrpcChannelBuilder;

import com.google.common.collect.ImmutableMap;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * Integration tests for Alluxio high availability when Zookeeper has failures.
 */
public class ZookeeperFailureIntegrationTest extends BaseIntegrationTest {
  private static final Logger LOG = LoggerFactory.getLogger(ZookeeperFailureIntegrationTest.class);

  @Rule
  public ConfigurationRule mConf = new ConfigurationRule(ImmutableMap.of(
      PropertyKey.USER_BLOCK_SIZE_BYTES_DEFAULT, "1000",
      PropertyKey.USER_RPC_RETRY_MAX_NUM_RETRY, "5",
      PropertyKey.USER_RPC_RETRY_BASE_SLEEP_MS, "500",
      PropertyKey.USER_RPC_RETRY_MAX_SLEEP_MS, "500",
      PropertyKey.USER_RPC_RETRY_MAX_DURATION, "2500")
  );

  public MultiProcessCluster mCluster;

  @After
  public void after() throws Exception {
    if (mCluster != null) {
      mCluster.destroy();
    }
  }

  /*
   * This test starts alluxio in HA mode, kills Zookeeper, waits for Alluxio to fail, then restarts
   * Zookeeper. Alluxio should recover when Zookeeper is restarted.
   */
  @Test
  public void zkFailure() throws Exception {
    mCluster = MultiProcessCluster.newBuilder(PortCoordination.ZOOKEEPER_FAILURE)
        .setClusterName("ZookeeperFailure")
        .setDeployMode(DeployMode.ZOOKEEPER_HA)
        .setNumMasters(1)
        .setNumWorkers(1)
        .build();
    mCluster.start();

    AlluxioOperationThread thread =
        new AlluxioOperationThread(mCluster.getFileSystemClient());
    thread.start();
    CommonUtils.waitFor("a successful operation to be performed", () -> thread.successes() > 0);
    mCluster.stopZk();
    long zkStopTime = System.currentTimeMillis();
    CommonUtils.waitFor("operations to start failing", () -> thread.getLatestFailure() != null);

    assertFalse(rpcServiceAvailable());
    LOG.info("First operation failed {}ms after stopping the Zookeeper cluster",
        System.currentTimeMillis() - zkStopTime);
    final long successes = thread.successes();
    mCluster.restartZk();
    long zkStartTime = System.currentTimeMillis();
    CommonUtils.waitFor("another successful operation to be performed",
        () -> thread.successes() > successes);
    thread.interrupt();
    thread.join();
    LOG.info("Recovered after {}ms", System.currentTimeMillis() - zkStartTime);
    mCluster.notifySuccess();
  }

  /*
   * This method uses a client with an explicit master address to ensure that the master has shut
   * down its rpc service.
   */
  private boolean rpcServiceAvailable() throws Exception {
    MasterNetAddress netAddress = mCluster.getMasterAddresses().get(0);
    InetSocketAddress address =
        new InetSocketAddress(netAddress.getHostname(), netAddress.getRpcPort());
    try {
      GrpcChannel channel = GrpcChannelBuilder
              .forAddress(address)
              .build();
      FileSystemMasterClientServiceGrpc.FileSystemMasterClientServiceBlockingStub client =
          FileSystemMasterClientServiceGrpc.newBlockingStub(channel);
      client.listStatus(ListStatusPRequest.getDefaultInstance());
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
