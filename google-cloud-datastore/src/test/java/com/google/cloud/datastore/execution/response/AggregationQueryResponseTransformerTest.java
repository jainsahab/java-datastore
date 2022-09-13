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
package com.google.cloud.datastore.execution.response;

import static com.google.cloud.datastore.ProtoTestData.intValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.AggregationResults;
import com.google.cloud.datastore.LongValue;
import com.google.datastore.v1.AggregationResultBatch;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.Value;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.Test;

public class AggregationQueryResponseTransformerTest {


  private AggregationQueryResponseTransformer responseTransformer = new AggregationQueryResponseTransformer();

  @Test
  public void shouldTransformAggregationQueryResponse() {
    Map<String, com.google.datastore.v1.Value> result1 = new HashMap<String, com.google.datastore.v1.Value>() {{
      put("count", intValue(209));
      put("count_upto_100", intValue(100));
    }};

    Map<String, com.google.datastore.v1.Value> result2 = new HashMap<String, com.google.datastore.v1.Value>() {{
      put("count", intValue(509));
      put("count_upto_100", intValue(100));
    }};

    AggregationResultBatch resultBatch = AggregationResultBatch.newBuilder()
        .addAggregationResults(com.google.datastore.v1.AggregationResult.newBuilder()
            .putAllAggregateProperties(result1).build())
        .addAggregationResults(com.google.datastore.v1.AggregationResult.newBuilder()
            .putAllAggregateProperties(result2).build())
        .build();
    RunAggregationQueryResponse runAggregationQueryResponse = RunAggregationQueryResponse.newBuilder()
        .setBatch(resultBatch)
        .build();

    AggregationResults aggregationResults = responseTransformer.transform(
        runAggregationQueryResponse);

    assertThat(aggregationResults.size(), equalTo(2));
    assertThat(aggregationResults.get(0), equalTo(new AggregationResult(toDomainValues(result1))));
    assertThat(aggregationResults.get(1), equalTo(new AggregationResult(toDomainValues(result2))));

  }

  private Map<String, LongValue> toDomainValues(Map<String, com.google.datastore.v1.Value> map) {

    return map
        .entrySet()
        .stream()
        .map((Function<Entry<String, Value>, Entry<String, LongValue>>) entry ->
            new SimpleEntry<>(entry.getKey(), (LongValue) LongValue.fromPb(entry.getValue())))
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
  }
}