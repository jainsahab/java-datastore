// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/datastore/v1/entity.proto

package com.google.datastore.v1;

public interface EntityOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.Entity)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The entity's key.
   * An entity must have a key, unless otherwise documented (for example,
   * an entity in `Value.entity_value` may have no key).
   * An entity's kind is its key path's last element's kind,
   * or null if it has no key.
   * </pre>
   *
   * <code>.google.datastore.v1.Key key = 1;</code>
   * @return Whether the key field is set.
   */
  boolean hasKey();
  /**
   * <pre>
   * The entity's key.
   * An entity must have a key, unless otherwise documented (for example,
   * an entity in `Value.entity_value` may have no key).
   * An entity's kind is its key path's last element's kind,
   * or null if it has no key.
   * </pre>
   *
   * <code>.google.datastore.v1.Key key = 1;</code>
   * @return The key.
   */
  com.google.datastore.v1.Key getKey();
  /**
   * <pre>
   * The entity's key.
   * An entity must have a key, unless otherwise documented (for example,
   * an entity in `Value.entity_value` may have no key).
   * An entity's kind is its key path's last element's kind,
   * or null if it has no key.
   * </pre>
   *
   * <code>.google.datastore.v1.Key key = 1;</code>
   */
  com.google.datastore.v1.KeyOrBuilder getKeyOrBuilder();

  /**
   * <pre>
   * The entity's properties.
   * The map's keys are property names.
   * A property name matching regex `__.*__` is reserved.
   * A reserved property name is forbidden in certain documented contexts.
   * The map keys, represented as UTF-8, must not exceed 1,500 bytes and cannot
   * be empty.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; properties = 3;</code>
   */
  int getPropertiesCount();
  /**
   * <pre>
   * The entity's properties.
   * The map's keys are property names.
   * A property name matching regex `__.*__` is reserved.
   * A reserved property name is forbidden in certain documented contexts.
   * The map keys, represented as UTF-8, must not exceed 1,500 bytes and cannot
   * be empty.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; properties = 3;</code>
   */
  boolean containsProperties(
      java.lang.String key);
  /**
   * Use {@link #getPropertiesMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, com.google.datastore.v1.Value>
  getProperties();
  /**
   * <pre>
   * The entity's properties.
   * The map's keys are property names.
   * A property name matching regex `__.*__` is reserved.
   * A reserved property name is forbidden in certain documented contexts.
   * The map keys, represented as UTF-8, must not exceed 1,500 bytes and cannot
   * be empty.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; properties = 3;</code>
   */
  java.util.Map<java.lang.String, com.google.datastore.v1.Value>
  getPropertiesMap();
  /**
   * <pre>
   * The entity's properties.
   * The map's keys are property names.
   * A property name matching regex `__.*__` is reserved.
   * A reserved property name is forbidden in certain documented contexts.
   * The map keys, represented as UTF-8, must not exceed 1,500 bytes and cannot
   * be empty.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; properties = 3;</code>
   */
  /* nullable */
com.google.datastore.v1.Value getPropertiesOrDefault(
      java.lang.String key,
      /* nullable */
com.google.datastore.v1.Value defaultValue);
  /**
   * <pre>
   * The entity's properties.
   * The map's keys are property names.
   * A property name matching regex `__.*__` is reserved.
   * A reserved property name is forbidden in certain documented contexts.
   * The map keys, represented as UTF-8, must not exceed 1,500 bytes and cannot
   * be empty.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; properties = 3;</code>
   */
  com.google.datastore.v1.Value getPropertiesOrThrow(
      java.lang.String key);
}
