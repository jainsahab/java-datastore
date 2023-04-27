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

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

public class AggregationResultTest {

  @Test
  public void shouldGetLongAggregatedResultValueByAlias() {
    AggregationResult aggregationResult =
        new AggregationResult(
            ImmutableMap.of(
                "count", LongValue.of(45),
                "property_2", LongValue.of(30)));

    assertThat(aggregationResult.get("count")).isEqualTo(45L);
    assertThat(aggregationResult.get("property_2")).isEqualTo(30L);
  }

  @Test
  public void shouldGetDoubleAggregatedResultValueByAlias() {
    AggregationResult aggregationResult =
        new AggregationResult(
            ImmutableMap.of(
                "qty_avg", DoubleValue.of(45.9322),
                "qty_sum", DoubleValue.of(783.2134)));

    assertThat(aggregationResult.getDouble("qty_avg")).isEqualTo(45.9322);
    assertThat(aggregationResult.getDouble("qty_sum")).isEqualTo(783.2134);
  }

  @Test
  public void shouldGetLongAggregatedResultValueAsDouble() {
    AggregationResult aggregationResult =
        new AggregationResult(ImmutableMap.of("count", LongValue.of(45)));

    assertThat(aggregationResult.getDouble("count")).isEqualTo(45D);
  }

  @Test
  public void shouldGetDoubleAggregatedResultValueAsLong() {
    AggregationResult aggregationResult =
        new AggregationResult(ImmutableMap.of("qty_avg", DoubleValue.of(45.9322)));

    assertThat(aggregationResult.get("qty_avg")).isEqualTo(45L);
  }
}
