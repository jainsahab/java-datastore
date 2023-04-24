// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/datastore/v1/datastore.proto

package com.google.datastore.v1;

public interface LookupRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.LookupRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. The ID of the project against which to make the request.
   * </pre>
   *
   * <code>string project_id = 8 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The projectId.
   */
  java.lang.String getProjectId();
  /**
   * <pre>
   * Required. The ID of the project against which to make the request.
   * </pre>
   *
   * <code>string project_id = 8 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The bytes for projectId.
   */
  com.google.protobuf.ByteString
      getProjectIdBytes();

  /**
   * <pre>
   * The ID of the database against which to make the request.
   * '(default)' is not allowed; please use empty string '' to refer the default
   * database.
   * </pre>
   *
   * <code>string database_id = 9;</code>
   * @return The databaseId.
   */
  java.lang.String getDatabaseId();
  /**
   * <pre>
   * The ID of the database against which to make the request.
   * '(default)' is not allowed; please use empty string '' to refer the default
   * database.
   * </pre>
   *
   * <code>string database_id = 9;</code>
   * @return The bytes for databaseId.
   */
  com.google.protobuf.ByteString
      getDatabaseIdBytes();

  /**
   * <pre>
   * The options for this lookup request.
   * </pre>
   *
   * <code>.google.datastore.v1.ReadOptions read_options = 1;</code>
   * @return Whether the readOptions field is set.
   */
  boolean hasReadOptions();
  /**
   * <pre>
   * The options for this lookup request.
   * </pre>
   *
   * <code>.google.datastore.v1.ReadOptions read_options = 1;</code>
   * @return The readOptions.
   */
  com.google.datastore.v1.ReadOptions getReadOptions();
  /**
   * <pre>
   * The options for this lookup request.
   * </pre>
   *
   * <code>.google.datastore.v1.ReadOptions read_options = 1;</code>
   */
  com.google.datastore.v1.ReadOptionsOrBuilder getReadOptionsOrBuilder();

  /**
   * <pre>
   * Required. Keys of entities to look up.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  java.util.List<com.google.datastore.v1.Key> 
      getKeysList();
  /**
   * <pre>
   * Required. Keys of entities to look up.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  com.google.datastore.v1.Key getKeys(int index);
  /**
   * <pre>
   * Required. Keys of entities to look up.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  int getKeysCount();
  /**
   * <pre>
   * Required. Keys of entities to look up.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  java.util.List<? extends com.google.datastore.v1.KeyOrBuilder> 
      getKeysOrBuilderList();
  /**
   * <pre>
   * Required. Keys of entities to look up.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  com.google.datastore.v1.KeyOrBuilder getKeysOrBuilder(
      int index);
}
