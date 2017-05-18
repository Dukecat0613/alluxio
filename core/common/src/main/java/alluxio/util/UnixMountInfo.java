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

package alluxio.util;

import com.google.common.base.Objects;

/**
 * Class representing an entry in a Unix /etc/fstab file.
 */
public final class UnixMountInfo {
  private final String mDeviceSpec;
  private final String mMountPoint;
  private final String mFsType;
  private final Options mOptions;

  private UnixMountInfo(String deviceSpec, String mountPoint, String fsType, Options options) {
    mDeviceSpec = deviceSpec;
    mMountPoint = mountPoint;
    mFsType = fsType;
    mOptions = options;
  }

  /**
   * @return the device spec, or null if it couldn't be determined
   */
  public String getDeviceSpec() {
    return mDeviceSpec;
  }

  /**
   * @return the mount point, or null if it couldn't be determined
   */
  public String getMountPoint() {
    return mMountPoint;
  }

  /**
   * @return the filesystem type, or null if it couldn't be determined
   */
  public String getFsType() {
    return mFsType;
  }

  /**
   * @return the mount options
   */
  public Options getOptions() {
    return mOptions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UnixMountInfo)) {
      return false;
    }
    UnixMountInfo that = (UnixMountInfo) o;
    return Objects.equal(mDeviceSpec, that.mDeviceSpec)
        && Objects.equal(mMountPoint, that.mMountPoint)
        && Objects.equal(mFsType, that.mFsType)
        && Objects.equal(mOptions, that.mOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(mDeviceSpec, mMountPoint, mFsType, mOptions);
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this)
        .add("deviceSpec", mDeviceSpec)
        .add("mountPoint", mMountPoint)
        .add("fsType", mFsType)
        .add("options", mOptions)
        .toString();
  }

  /** Builder for {@link UnixMountInfo}. */
  public static class Builder {
    private String mDeviceSpec;
    private String mMountPoint;
    private String mFsType;
    private Options mOptions;

    /** Constructs a new Unix mount info builder. */
    public Builder() {}

    /**
     * @param deviceSpec the device spec to set
     * @return the builder
     */
    public Builder setDeviceSpec(String deviceSpec) {
      mDeviceSpec = deviceSpec;
      return this;
    }

    /**
     * @param mountPoint the mount point to set
     * @return the builder
     */
    public Builder setMountPoint(String mountPoint) {
      mMountPoint = mountPoint;
      return this;
    }

    /**
     * @param fsType the fs type to set
     * @return the builder
     */
    public Builder setFsType(String fsType) {
      mFsType = fsType;
      return this;
    }

    /**
     * @param options the mount info options to set
     * @return the builder
     */
    public Builder setOptions(Options options) {
      mOptions = options;
      return this;
    }

    /**
     * @return the built Unix mount info
     */
    public UnixMountInfo build() {
      return new UnixMountInfo(mDeviceSpec, mMountPoint, mFsType, mOptions);
    }
  }

  /** Unix mount info options. */
  public final static class Options {
    private final Long mSize;

    private Options(Long size) {
      mSize = size;
    }

    /**
     * @return the mount point size, or null if it couldn't be determined
     */
    public Long getSize() {
      return mSize;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Options)) {
        return false;
      }
      Options that = (Options) o;
      return Objects.equal(mSize, that.mSize);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(mSize);
    }

    @Override
    public String toString() {
      return Objects.toStringHelper(this)
          .add("size", mSize)
          .toString();
    }

    /** Builder for Unix mount info options. */
    public static class Builder {
      private Long mSize;

      /** Constructs a new unix mount info options builder. */
      public Builder() {}

      /**
       * @param size the mount size to set
       * @return the builder
       */
      public Builder setSize(Long size) {
        mSize = size;
        return this;
      }

      /**
       * @return the built Unix mount info options
       */
      public Options build() {
        return new Options(mSize);
      }
    }
  }
}
