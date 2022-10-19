package com.example.datastore.aggregation;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.aggregation.Aggregation;
import com.google.common.collect.Iterables;

public class CountAggregationWithLimit {
  public static void invoke() {
    // [START datastore_count_aggregation_query_with_limit]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Task";

    Key task1Key = datastore.newKeyFactory().setKind(kind).newKey("task1");
    Key task2Key = datastore.newKeyFactory().setKind(kind).newKey("task2");
    Key task3Key = datastore.newKeyFactory().setKind(kind).newKey("task3");

    // Save all the tasks
    datastore.put(
        Entity.newBuilder(task1Key).set("done", true).build(),
        Entity.newBuilder(task2Key).set("done", false).build(),
        Entity.newBuilder(task3Key).set("done", true).build());

    EntityQuery selectAllTasks = Query.newEntityQueryBuilder().setKind(kind).setLimit(2).build();
    // Creating an aggregation query to get the count of all tasks
    AggregationQuery allTasksCountQuery =
        Query.newAggregationQueryBuilder()
            .over(selectAllTasks)
            .addAggregation(Aggregation.count().as("at_least"))
            .build();
    // Executing aggregation query
    AggregationResult limitQueryResult =
        Iterables.getOnlyElement(datastore.runAggregation(allTasksCountQuery));

    System.out.printf("We have at least %d tasks", limitQueryResult.get("at_least")); // 2

    // [END datastore_count_aggregation_query_with_limit]
  }
}
