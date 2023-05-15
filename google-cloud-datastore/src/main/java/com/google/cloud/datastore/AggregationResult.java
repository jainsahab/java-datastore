/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.datastore;

import static com.google.cloud.datastore.ValueType.DOUBLE;
import static com.google.cloud.datastore.ValueType.LONG;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/** Represents a result of an {@link AggregationQuery} query submission. */
public class AggregationResult {

  private final Map<String, Value<?>> properties;

  public AggregationResult(Map<String, Value<?>> properties) {
    this.properties = properties;
  }

  /**
   * Returns a result value for the given alias.
   *
   * @param alias A custom alias provided in the query or an autogenerated alias in the form of
   *     'property_\d'
   * @return An aggregation result value for the given alias.
   *
   * @deprecated Use {@link #getLong(String)} instead.
   */
  @Deprecated
  public Long get(String alias) {
    return getLong(alias);
  }

  /**
   * Returns a result value for the given alias.
   *
   * @param alias A custom alias provided in the query or an autogenerated alias in the form of
   *     'property_\d'
   * @return An aggregation result value for the given alias.
   */
  public Long getLong(String alias) {
    Value<?> value = properties.get(alias);
    if (value.getType() == DOUBLE) {
      return ((Double) value.get()).longValue();
    }
    return (Long) value.get();
  }

  public Double getDouble(String alias) {
    Value<?> value = properties.get(alias);
    if (value.getType() == LONG) {
      return ((Long) value.get()).doubleValue();
    }
    return (Double) value.get();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AggregationResult that = (AggregationResult) o;
    return properties.equals(that.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(properties);
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    for (Entry<String, Value<?>> entry : properties.entrySet()) {
      toStringHelper.add(entry.getKey(), entry.getValue().get());
    }
    return toStringHelper.toString();
  }
}
