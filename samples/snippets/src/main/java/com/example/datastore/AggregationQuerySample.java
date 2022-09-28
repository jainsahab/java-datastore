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
package com.example.datastore;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.GqlQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.aggregation.Aggregation;
import com.google.common.collect.Iterables;

public class AggregationQuerySample {

  public void aggregationQueryAndCountAggregation() {
    // [START datastore_count_aggregation_query]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Candidate";

    Key candidate1Key = datastore.newKeyFactory().setKind(kind).newKey("candidate1");
    Key candidate2Key = datastore.newKeyFactory().setKind(kind).newKey("candidate2");
    Key candidate3Key = datastore.newKeyFactory().setKind(kind).newKey("candidate3");

    // Save all the candidates
    datastore.put(
        Entity.newBuilder(candidate1Key).set("qualified", true).build(),
        Entity.newBuilder(candidate2Key).set("qualified", false).build(),
        Entity.newBuilder(candidate3Key).set("qualified", true).build()
    );

    EntityQuery selectAllCandidates = Query.newEntityQueryBuilder()
        .setKind(kind)
        .build();
    // Creating an aggregation query to get the count of all candidates
    AggregationQuery allCandidatesCountQuery = Query.newAggregationQueryBuilder()
        .over(selectAllCandidates)
        .addAggregation(Aggregation.count().as("total_count"))
        .addAggregation(Aggregation.count().as("count_with_limit").limit(2))
        .build();
    // Executing aggregation query
    AggregationResult allCandidatesCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(allCandidatesCountQuery));

    System.out.printf("We have at least %d candidates", allCandidatesCountQueryResult.get("count_with_limit")); // 2
    System.out.printf("Total candidates count is %d", allCandidatesCountQueryResult.get("total_count")); // 3


    EntityQuery qualifiedCandidates = Query.newEntityQueryBuilder()
        .setKind(kind)
        .setFilter(PropertyFilter.eq("qualified", true))
        .build();
    // Creating an aggregation query to get the count of all qualified candidates
    AggregationQuery qualifiedCandidatesCountQuery = Query.newAggregationQueryBuilder()
        .over(qualifiedCandidates)
        .addAggregation(Aggregation.count().as("total_qualified_count"))
        .build();

    // Executing aggregation query
    AggregationResult qualifiedCandidatesCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(qualifiedCandidatesCountQuery));

    System.out.printf("Total qualified candidates count is %d", qualifiedCandidatesCountQueryResult.get("total_qualified_count")); // 2

    // [END datastore_count_aggregation_query]

    datastore.delete(candidate1Key, candidate2Key, candidate3Key);
  }

  public void aggregationQueryAndCountAggregationWithGqlQuery() {
    // [START datastore_count_aggregation_query_gql]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Candidate";

    Key candidate1Key = datastore.newKeyFactory().setKind(kind).newKey("candidate1");
    Key candidate2Key = datastore.newKeyFactory().setKind(kind).newKey("candidate2");
    Key candidate3Key = datastore.newKeyFactory().setKind(kind).newKey("candidate3");

    // Save all the candidates
    datastore.put(
        Entity.newBuilder(candidate1Key).set("qualified", true).build(),
        Entity.newBuilder(candidate2Key).set("qualified", false).build(),
        Entity.newBuilder(candidate3Key).set("qualified", true).build()
    );

    GqlQuery<?> selectAllCandidates = Query.newGqlQueryBuilder(
        "AGGREGATE COUNT(*) AS total_count, COUNT_UP_TO(2) AS count_with_limit "
            + "OVER (SELECT * FROM Candidate)")
        .setAllowLiteral(true)
        .build();
    // Creating an aggregation query to get the count of all candidates
    AggregationQuery allCandidatesCountQuery = Query.newAggregationQueryBuilder()
        .over(selectAllCandidates)
        .build();
    // Executing aggregation query
    AggregationResult allCandidatesCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(allCandidatesCountQuery));

    System.out.printf("We have at least %d candidates", allCandidatesCountQueryResult.get("count_with_limit")); // 2
    System.out.printf("Total candidates count is %d", allCandidatesCountQueryResult.get("total_count")); // 3


    GqlQuery<?> qualifiedCandidates = Query.newGqlQueryBuilder(
            "AGGREGATE COUNT(*) AS total_qualified_count "
                + "OVER (SELECT * FROM Candidate WHERE qualified = true)")
        .setAllowLiteral(true)
        .build();
    // Creating an aggregation query to get the count of all qualified candidates
    AggregationQuery qualifiedCandidatesCountQuery = Query.newAggregationQueryBuilder()
        .over(qualifiedCandidates)
        .build();

    // Executing aggregation query
    AggregationResult qualifiedCandidatesCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(qualifiedCandidatesCountQuery));

    System.out.printf("Total qualified candidates count is %d", qualifiedCandidatesCountQueryResult.get("total_qualified_count")); // 2

    // [END datastore_count_aggregation_query_gql]

    datastore.delete(candidate1Key, candidate2Key, candidate3Key);
  }

}
