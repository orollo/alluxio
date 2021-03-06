// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grpc/key_value_master.proto

package alluxio.grpc;

/**
 * Protobuf type {@code alluxio.grpc.keyvalue.GetPartitionInfoPResponse}
 */
public  final class GetPartitionInfoPResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:alluxio.grpc.keyvalue.GetPartitionInfoPResponse)
    GetPartitionInfoPResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetPartitionInfoPResponse.newBuilder() to construct.
  private GetPartitionInfoPResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetPartitionInfoPResponse() {
    partitionInfo_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetPartitionInfoPResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              partitionInfo_ = new java.util.ArrayList<alluxio.grpc.PartitionInfo>();
              mutable_bitField0_ |= 0x00000001;
            }
            partitionInfo_.add(
                input.readMessage(alluxio.grpc.PartitionInfo.PARSER, extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        partitionInfo_ = java.util.Collections.unmodifiableList(partitionInfo_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return alluxio.grpc.KeyValueMasterProto.internal_static_alluxio_grpc_keyvalue_GetPartitionInfoPResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return alluxio.grpc.KeyValueMasterProto.internal_static_alluxio_grpc_keyvalue_GetPartitionInfoPResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            alluxio.grpc.GetPartitionInfoPResponse.class, alluxio.grpc.GetPartitionInfoPResponse.Builder.class);
  }

  public static final int PARTITIONINFO_FIELD_NUMBER = 1;
  private java.util.List<alluxio.grpc.PartitionInfo> partitionInfo_;
  /**
   * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
   */
  public java.util.List<alluxio.grpc.PartitionInfo> getPartitionInfoList() {
    return partitionInfo_;
  }
  /**
   * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
   */
  public java.util.List<? extends alluxio.grpc.PartitionInfoOrBuilder> 
      getPartitionInfoOrBuilderList() {
    return partitionInfo_;
  }
  /**
   * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
   */
  public int getPartitionInfoCount() {
    return partitionInfo_.size();
  }
  /**
   * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
   */
  public alluxio.grpc.PartitionInfo getPartitionInfo(int index) {
    return partitionInfo_.get(index);
  }
  /**
   * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
   */
  public alluxio.grpc.PartitionInfoOrBuilder getPartitionInfoOrBuilder(
      int index) {
    return partitionInfo_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < partitionInfo_.size(); i++) {
      output.writeMessage(1, partitionInfo_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < partitionInfo_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, partitionInfo_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof alluxio.grpc.GetPartitionInfoPResponse)) {
      return super.equals(obj);
    }
    alluxio.grpc.GetPartitionInfoPResponse other = (alluxio.grpc.GetPartitionInfoPResponse) obj;

    boolean result = true;
    result = result && getPartitionInfoList()
        .equals(other.getPartitionInfoList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getPartitionInfoCount() > 0) {
      hash = (37 * hash) + PARTITIONINFO_FIELD_NUMBER;
      hash = (53 * hash) + getPartitionInfoList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static alluxio.grpc.GetPartitionInfoPResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static alluxio.grpc.GetPartitionInfoPResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static alluxio.grpc.GetPartitionInfoPResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static alluxio.grpc.GetPartitionInfoPResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static alluxio.grpc.GetPartitionInfoPResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static alluxio.grpc.GetPartitionInfoPResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static alluxio.grpc.GetPartitionInfoPResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static alluxio.grpc.GetPartitionInfoPResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static alluxio.grpc.GetPartitionInfoPResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static alluxio.grpc.GetPartitionInfoPResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static alluxio.grpc.GetPartitionInfoPResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static alluxio.grpc.GetPartitionInfoPResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(alluxio.grpc.GetPartitionInfoPResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code alluxio.grpc.keyvalue.GetPartitionInfoPResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:alluxio.grpc.keyvalue.GetPartitionInfoPResponse)
      alluxio.grpc.GetPartitionInfoPResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return alluxio.grpc.KeyValueMasterProto.internal_static_alluxio_grpc_keyvalue_GetPartitionInfoPResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return alluxio.grpc.KeyValueMasterProto.internal_static_alluxio_grpc_keyvalue_GetPartitionInfoPResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              alluxio.grpc.GetPartitionInfoPResponse.class, alluxio.grpc.GetPartitionInfoPResponse.Builder.class);
    }

    // Construct using alluxio.grpc.GetPartitionInfoPResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getPartitionInfoFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (partitionInfoBuilder_ == null) {
        partitionInfo_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        partitionInfoBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return alluxio.grpc.KeyValueMasterProto.internal_static_alluxio_grpc_keyvalue_GetPartitionInfoPResponse_descriptor;
    }

    public alluxio.grpc.GetPartitionInfoPResponse getDefaultInstanceForType() {
      return alluxio.grpc.GetPartitionInfoPResponse.getDefaultInstance();
    }

    public alluxio.grpc.GetPartitionInfoPResponse build() {
      alluxio.grpc.GetPartitionInfoPResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public alluxio.grpc.GetPartitionInfoPResponse buildPartial() {
      alluxio.grpc.GetPartitionInfoPResponse result = new alluxio.grpc.GetPartitionInfoPResponse(this);
      int from_bitField0_ = bitField0_;
      if (partitionInfoBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          partitionInfo_ = java.util.Collections.unmodifiableList(partitionInfo_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.partitionInfo_ = partitionInfo_;
      } else {
        result.partitionInfo_ = partitionInfoBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof alluxio.grpc.GetPartitionInfoPResponse) {
        return mergeFrom((alluxio.grpc.GetPartitionInfoPResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(alluxio.grpc.GetPartitionInfoPResponse other) {
      if (other == alluxio.grpc.GetPartitionInfoPResponse.getDefaultInstance()) return this;
      if (partitionInfoBuilder_ == null) {
        if (!other.partitionInfo_.isEmpty()) {
          if (partitionInfo_.isEmpty()) {
            partitionInfo_ = other.partitionInfo_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensurePartitionInfoIsMutable();
            partitionInfo_.addAll(other.partitionInfo_);
          }
          onChanged();
        }
      } else {
        if (!other.partitionInfo_.isEmpty()) {
          if (partitionInfoBuilder_.isEmpty()) {
            partitionInfoBuilder_.dispose();
            partitionInfoBuilder_ = null;
            partitionInfo_ = other.partitionInfo_;
            bitField0_ = (bitField0_ & ~0x00000001);
            partitionInfoBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getPartitionInfoFieldBuilder() : null;
          } else {
            partitionInfoBuilder_.addAllMessages(other.partitionInfo_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      alluxio.grpc.GetPartitionInfoPResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (alluxio.grpc.GetPartitionInfoPResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<alluxio.grpc.PartitionInfo> partitionInfo_ =
      java.util.Collections.emptyList();
    private void ensurePartitionInfoIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        partitionInfo_ = new java.util.ArrayList<alluxio.grpc.PartitionInfo>(partitionInfo_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        alluxio.grpc.PartitionInfo, alluxio.grpc.PartitionInfo.Builder, alluxio.grpc.PartitionInfoOrBuilder> partitionInfoBuilder_;

    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public java.util.List<alluxio.grpc.PartitionInfo> getPartitionInfoList() {
      if (partitionInfoBuilder_ == null) {
        return java.util.Collections.unmodifiableList(partitionInfo_);
      } else {
        return partitionInfoBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public int getPartitionInfoCount() {
      if (partitionInfoBuilder_ == null) {
        return partitionInfo_.size();
      } else {
        return partitionInfoBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public alluxio.grpc.PartitionInfo getPartitionInfo(int index) {
      if (partitionInfoBuilder_ == null) {
        return partitionInfo_.get(index);
      } else {
        return partitionInfoBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public Builder setPartitionInfo(
        int index, alluxio.grpc.PartitionInfo value) {
      if (partitionInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePartitionInfoIsMutable();
        partitionInfo_.set(index, value);
        onChanged();
      } else {
        partitionInfoBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public Builder setPartitionInfo(
        int index, alluxio.grpc.PartitionInfo.Builder builderForValue) {
      if (partitionInfoBuilder_ == null) {
        ensurePartitionInfoIsMutable();
        partitionInfo_.set(index, builderForValue.build());
        onChanged();
      } else {
        partitionInfoBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public Builder addPartitionInfo(alluxio.grpc.PartitionInfo value) {
      if (partitionInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePartitionInfoIsMutable();
        partitionInfo_.add(value);
        onChanged();
      } else {
        partitionInfoBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public Builder addPartitionInfo(
        int index, alluxio.grpc.PartitionInfo value) {
      if (partitionInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePartitionInfoIsMutable();
        partitionInfo_.add(index, value);
        onChanged();
      } else {
        partitionInfoBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public Builder addPartitionInfo(
        alluxio.grpc.PartitionInfo.Builder builderForValue) {
      if (partitionInfoBuilder_ == null) {
        ensurePartitionInfoIsMutable();
        partitionInfo_.add(builderForValue.build());
        onChanged();
      } else {
        partitionInfoBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public Builder addPartitionInfo(
        int index, alluxio.grpc.PartitionInfo.Builder builderForValue) {
      if (partitionInfoBuilder_ == null) {
        ensurePartitionInfoIsMutable();
        partitionInfo_.add(index, builderForValue.build());
        onChanged();
      } else {
        partitionInfoBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public Builder addAllPartitionInfo(
        java.lang.Iterable<? extends alluxio.grpc.PartitionInfo> values) {
      if (partitionInfoBuilder_ == null) {
        ensurePartitionInfoIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, partitionInfo_);
        onChanged();
      } else {
        partitionInfoBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public Builder clearPartitionInfo() {
      if (partitionInfoBuilder_ == null) {
        partitionInfo_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        partitionInfoBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public Builder removePartitionInfo(int index) {
      if (partitionInfoBuilder_ == null) {
        ensurePartitionInfoIsMutable();
        partitionInfo_.remove(index);
        onChanged();
      } else {
        partitionInfoBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public alluxio.grpc.PartitionInfo.Builder getPartitionInfoBuilder(
        int index) {
      return getPartitionInfoFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public alluxio.grpc.PartitionInfoOrBuilder getPartitionInfoOrBuilder(
        int index) {
      if (partitionInfoBuilder_ == null) {
        return partitionInfo_.get(index);  } else {
        return partitionInfoBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public java.util.List<? extends alluxio.grpc.PartitionInfoOrBuilder> 
         getPartitionInfoOrBuilderList() {
      if (partitionInfoBuilder_ != null) {
        return partitionInfoBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(partitionInfo_);
      }
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public alluxio.grpc.PartitionInfo.Builder addPartitionInfoBuilder() {
      return getPartitionInfoFieldBuilder().addBuilder(
          alluxio.grpc.PartitionInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public alluxio.grpc.PartitionInfo.Builder addPartitionInfoBuilder(
        int index) {
      return getPartitionInfoFieldBuilder().addBuilder(
          index, alluxio.grpc.PartitionInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .alluxio.grpc.keyvalue.PartitionInfo partitionInfo = 1;</code>
     */
    public java.util.List<alluxio.grpc.PartitionInfo.Builder> 
         getPartitionInfoBuilderList() {
      return getPartitionInfoFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        alluxio.grpc.PartitionInfo, alluxio.grpc.PartitionInfo.Builder, alluxio.grpc.PartitionInfoOrBuilder> 
        getPartitionInfoFieldBuilder() {
      if (partitionInfoBuilder_ == null) {
        partitionInfoBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            alluxio.grpc.PartitionInfo, alluxio.grpc.PartitionInfo.Builder, alluxio.grpc.PartitionInfoOrBuilder>(
                partitionInfo_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        partitionInfo_ = null;
      }
      return partitionInfoBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:alluxio.grpc.keyvalue.GetPartitionInfoPResponse)
  }

  // @@protoc_insertion_point(class_scope:alluxio.grpc.keyvalue.GetPartitionInfoPResponse)
  private static final alluxio.grpc.GetPartitionInfoPResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new alluxio.grpc.GetPartitionInfoPResponse();
  }

  public static alluxio.grpc.GetPartitionInfoPResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<GetPartitionInfoPResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetPartitionInfoPResponse>() {
    public GetPartitionInfoPResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetPartitionInfoPResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetPartitionInfoPResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetPartitionInfoPResponse> getParserForType() {
    return PARSER;
  }

  public alluxio.grpc.GetPartitionInfoPResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

