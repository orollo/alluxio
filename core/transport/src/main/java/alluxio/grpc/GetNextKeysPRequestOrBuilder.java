// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grpc/key_value_worker.proto

package alluxio.grpc;

public interface GetNextKeysPRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:alluxio.grpc.keyvalue.GetNextKeysPRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int64 blockId = 1;</code>
   */
  boolean hasBlockId();
  /**
   * <code>optional int64 blockId = 1;</code>
   */
  long getBlockId();

  /**
   * <code>optional bytes key = 2;</code>
   */
  boolean hasKey();
  /**
   * <code>optional bytes key = 2;</code>
   */
  com.google.protobuf.ByteString getKey();

  /**
   * <code>optional int32 numKeys = 3;</code>
   */
  boolean hasNumKeys();
  /**
   * <code>optional int32 numKeys = 3;</code>
   */
  int getNumKeys();

  /**
   * <code>optional .alluxio.grpc.keyvalue.GetNextKeysPOptions options = 4;</code>
   */
  boolean hasOptions();
  /**
   * <code>optional .alluxio.grpc.keyvalue.GetNextKeysPOptions options = 4;</code>
   */
  alluxio.grpc.GetNextKeysPOptions getOptions();
  /**
   * <code>optional .alluxio.grpc.keyvalue.GetNextKeysPOptions options = 4;</code>
   */
  alluxio.grpc.GetNextKeysPOptionsOrBuilder getOptionsOrBuilder();
}
