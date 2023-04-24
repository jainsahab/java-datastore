// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/datastore/v1/aggregation_result.proto

package com.google.datastore.v1;

public interface AggregationResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.AggregationResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The result of the aggregation functions, ex: `COUNT(*) AS total_entities`.
   * The key is the
   * [alias][google.datastore.v1.AggregationQuery.Aggregation.alias] assigned to
   * the aggregation function on input and the size of this map equals the
   * number of aggregation functions in the query.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; aggregate_properties = 2;</code>
   */
  int getAggregatePropertiesCount();
  /**
   * <pre>
   * The result of the aggregation functions, ex: `COUNT(*) AS total_entities`.
   * The key is the
   * [alias][google.datastore.v1.AggregationQuery.Aggregation.alias] assigned to
   * the aggregation function on input and the size of this map equals the
   * number of aggregation functions in the query.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; aggregate_properties = 2;</code>
   */
  boolean containsAggregateProperties(
      java.lang.String key);
  /**
   * Use {@link #getAggregatePropertiesMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, com.google.datastore.v1.Value>
  getAggregateProperties();
  /**
   * <pre>
   * The result of the aggregation functions, ex: `COUNT(*) AS total_entities`.
   * The key is the
   * [alias][google.datastore.v1.AggregationQuery.Aggregation.alias] assigned to
   * the aggregation function on input and the size of this map equals the
   * number of aggregation functions in the query.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; aggregate_properties = 2;</code>
   */
  java.util.Map<java.lang.String, com.google.datastore.v1.Value>
  getAggregatePropertiesMap();
  /**
   * <pre>
   * The result of the aggregation functions, ex: `COUNT(*) AS total_entities`.
   * The key is the
   * [alias][google.datastore.v1.AggregationQuery.Aggregation.alias] assigned to
   * the aggregation function on input and the size of this map equals the
   * number of aggregation functions in the query.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; aggregate_properties = 2;</code>
   */
  /* nullable */
com.google.datastore.v1.Value getAggregatePropertiesOrDefault(
      java.lang.String key,
      /* nullable */
com.google.datastore.v1.Value defaultValue);
  /**
   * <pre>
   * The result of the aggregation functions, ex: `COUNT(*) AS total_entities`.
   * The key is the
   * [alias][google.datastore.v1.AggregationQuery.Aggregation.alias] assigned to
   * the aggregation function on input and the size of this map equals the
   * number of aggregation functions in the query.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; aggregate_properties = 2;</code>
   */
  com.google.datastore.v1.Value getAggregatePropertiesOrThrow(
      java.lang.String key);
}
