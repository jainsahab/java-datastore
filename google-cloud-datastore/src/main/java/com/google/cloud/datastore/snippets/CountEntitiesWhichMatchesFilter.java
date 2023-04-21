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
package com.google.cloud.datastore.snippets;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.AggregationResults;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.aggregation.Aggregation;
import com.google.common.collect.Iterables;

public class CountEntitiesWhichMatchesFilter {

  public static void main(String[] args) {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    StructuredQuery<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Person")
        .setFilter(PropertyFilter.eq("favorite_food", "pizza"))
        .build();
    AggregationQuery countQueryRequest = Query.newAggregationQueryBuilder()
        .addAggregation(Aggregation.count().as("number_of_people"))
        .over(query)
        .build();
    AggregationResult aggregationResult = Iterables.getOnlyElement(datastore.runAggregation(countQueryRequest));

    System.out.printf("Total %d people are invited to pizza party.", aggregationResult.get("number_of_people"));
  }
}
