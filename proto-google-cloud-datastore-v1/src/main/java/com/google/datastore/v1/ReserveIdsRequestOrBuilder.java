/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/datastore/v1/datastore.proto

package com.google.datastore.v1;

public interface ReserveIdsRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.ReserveIdsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The ID of the project against which to make the request.
   * </pre>
   *
   * <code>string project_id = 8 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The projectId.
   */
  java.lang.String getProjectId();
  /**
   *
   *
   * <pre>
   * Required. The ID of the project against which to make the request.
   * </pre>
   *
   * <code>string project_id = 8 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The bytes for projectId.
   */
  com.google.protobuf.ByteString getProjectIdBytes();

  /**
   *
   *
   * <pre>
   * The ID of the database against which to make the request.
   *
   * '(default)' is not allowed; please use empty string '' to refer the default
   * database.
   * </pre>
   *
   * <code>string database_id = 9;</code>
   *
   * @return The databaseId.
   */
  java.lang.String getDatabaseId();
  /**
   *
   *
   * <pre>
   * The ID of the database against which to make the request.
   *
   * '(default)' is not allowed; please use empty string '' to refer the default
   * database.
   * </pre>
   *
   * <code>string database_id = 9;</code>
   *
   * @return The bytes for databaseId.
   */
  com.google.protobuf.ByteString getDatabaseIdBytes();

  /**
   *
   *
   * <pre>
   * Required. A list of keys with complete key paths whose numeric IDs should
   * not be auto-allocated.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  java.util.List<com.google.datastore.v1.Key> getKeysList();
  /**
   *
   *
   * <pre>
   * Required. A list of keys with complete key paths whose numeric IDs should
   * not be auto-allocated.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.datastore.v1.Key getKeys(int index);
  /**
   *
   *
   * <pre>
   * Required. A list of keys with complete key paths whose numeric IDs should
   * not be auto-allocated.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  int getKeysCount();
  /**
   *
   *
   * <pre>
   * Required. A list of keys with complete key paths whose numeric IDs should
   * not be auto-allocated.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  java.util.List<? extends com.google.datastore.v1.KeyOrBuilder> getKeysOrBuilderList();
  /**
   *
   *
   * <pre>
   * Required. A list of keys with complete key paths whose numeric IDs should
   * not be auto-allocated.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.datastore.v1.KeyOrBuilder getKeysOrBuilder(int index);
}
