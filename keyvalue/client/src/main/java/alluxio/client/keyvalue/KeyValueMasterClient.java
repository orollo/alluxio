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

package alluxio.client.keyvalue;

import alluxio.AbstractMasterClient;
import alluxio.AlluxioURI;
import alluxio.Constants;
import alluxio.grpc.CompletePartitionPRequest;
import alluxio.grpc.CompleteStorePRequest;
import alluxio.grpc.CreateStorePRequest;
import alluxio.grpc.DeleteStorePRequest;
import alluxio.grpc.GetPartitionInfoPRequest;
import alluxio.grpc.KeyValueMasterClientServiceGrpc;
import alluxio.grpc.MergeStorePRequest;
import alluxio.grpc.PartitionInfo;
import alluxio.grpc.RenameStorePRequest;
import alluxio.grpc.ServiceType;
import alluxio.master.MasterClientConfig;

import java.io.IOException;
import java.util.List;

import javax.annotation.concurrent.ThreadSafe;

/**
 * A wrapper for the gRPC client to interact with the key-value master, used by Alluxio clients.
 *
 *  @deprecated This class is deprecated since version 2.0
 */
@ThreadSafe
@Deprecated
public final class KeyValueMasterClient extends AbstractMasterClient {
  private KeyValueMasterClientServiceGrpc.KeyValueMasterClientServiceBlockingStub mClient =
      null;

  /**
   * Creates a new key-value master client.
   *
   * @param conf master client configuration
   */
  public KeyValueMasterClient(MasterClientConfig conf) {
    super(conf);
  }

  @Override
  protected ServiceType getRemoteServiceType() {
    return ServiceType.KEY_VALUE_MASTER_CLIENT_SERVICE;
  }

  @Override
  protected String getServiceName() {
    return Constants.KEY_VALUE_MASTER_CLIENT_SERVICE_NAME;
  }

  @Override
  protected long getServiceVersion() {
    return Constants.KEY_VALUE_MASTER_CLIENT_SERVICE_VERSION;
  }

  @Override
  protected void afterConnect() throws IOException {
    mClient = KeyValueMasterClientServiceGrpc.newBlockingStub(mChannel);
  }

  /**
   * Marks a partition complete and adds it to an incomplete key-value store.
   *
   * @param path URI of the key-value store
   * @param info information of this completed partition
   */
  public void completePartition(final AlluxioURI path, final PartitionInfo info)
      throws IOException {
    retryRPC(new RpcCallable<Void>() {
      @Override
      public Void call() {
        mClient.completePartition(CompletePartitionPRequest.newBuilder().setPath(path.getPath())
            .setPartitionInfo(info).build());
        return null;
      }
    });
  }

  /**
   * Marks a key-value store complete.
   *
   * @param path URI of the key-value store
   */
  public void completeStore(final AlluxioURI path) throws IOException {
    retryRPC(new RpcCallable<Void>() {
      @Override
      public Void call() {
        mClient
            .completeStore(CompleteStorePRequest.newBuilder().setPath(path.getPath()).build());
        return null;
      }
    });
  }

  /**
   * Creates a new key-value store.
   *
   * @param path URI of the key-value store
   */
  public void createStore(final AlluxioURI path) throws IOException {
    retryRPC(new RpcCallable<Void>() {
      @Override
      public Void call() {
        mClient.createStore(CreateStorePRequest.newBuilder().setPath(path.getPath()).build());
        return null;
      }
    });
  }

  /**
   * Gets a list of partitions of a given key-value store.
   *
   * @param path URI of the key-value store
   * @return a list of partition information
   */
  public List<PartitionInfo> getPartitionInfo(final AlluxioURI path)
      throws IOException {
    return retryRPC(new RpcCallable<List<PartitionInfo>>() {
      @Override
      public List<PartitionInfo> call() {
        return mClient
            .getPartitionInfo(GetPartitionInfoPRequest.newBuilder().setPath(path.getPath()).build())
            .getPartitionInfoList();
      }
    });
  }

  /**
   * Deletes a completed key-value store.
   *
   * @param path URI of the store
   */
  public void deleteStore(final AlluxioURI path) throws IOException {
    retryRPC(new RpcCallable<Void>() {
      @Override
      public Void call() {
        mClient.deleteStore(DeleteStorePRequest.newBuilder().setPath(path.getPath()).build());
        return null;
      }
    });
  }

  /**
   * Renames a completed key-value store.
   *
   * @param oldPath old URI of the store
   * @param newPath new URI of the store
   */
  public void renameStore(final AlluxioURI oldPath, final AlluxioURI newPath)
      throws IOException {
    retryRPC(new RpcCallable<Void>() {
      @Override
      public Void call() {
        mClient.renameStore(RenameStorePRequest.newBuilder().setOldPath(oldPath.getPath())
            .setNewPath(newPath.getPath()).build());
        return null;
      }
    });
  }

  /**
   * Merges one completed key-value store to another completed key-value store.
   *
   * @param fromPath URI of the store to be merged
   * @param toPath URI of the store to be merged to
   */
  void mergeStore(final AlluxioURI fromPath, final AlluxioURI toPath) throws IOException {
    retryRPC(new RpcCallable<Void>() {
      @Override
      public Void call() {
        mClient.mergeStore(MergeStorePRequest.newBuilder().setFromPath(fromPath.getPath())
            .setToPath(toPath.getPath()).build());
        return null;
      }
    });
  }
}
