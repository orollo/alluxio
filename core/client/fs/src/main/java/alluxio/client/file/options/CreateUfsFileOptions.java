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

package alluxio.client.file.options;

import alluxio.security.authorization.Mode;
import alluxio.util.ModeUtils;
import alluxio.util.SecurityUtils;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * Options for creating a UFS file. Currently we do not allow user to set arbitrary owner and
 * group options. The owner and group will be set to the user login.
 */
@NotThreadSafe
public final class CreateUfsFileOptions
    extends alluxio.file.options.CreateUfsFileOptions<CreateUfsFileOptions> {
  /**
   * Creates a default {@link CreateUfsFileOptions} with owner, group from login module and
   * default file mode.
   *
   * @return the default {@link CreateUfsFileOptions}
   */
  public static CreateUfsFileOptions defaults() {
    return new CreateUfsFileOptions();
  }

  private CreateUfsFileOptions() {
    mOwner = SecurityUtils.getOwnerFromLoginModule();
    mGroup = SecurityUtils.getGroupFromLoginModule();
    mMode = ModeUtils.applyFileUMask(Mode.defaults());
    // TODO(chaomin): set permission based on the alluxio file. Not needed for now since the
    // file is always created with default permission.
  }
}
