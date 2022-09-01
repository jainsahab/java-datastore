package com.datastore.testing;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyQuery;
import com.google.cloud.datastore.ProjectionEntity;
import com.google.cloud.datastore.ProjectionEntityQuery;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.cloud.datastore.spi.v1.HttpDatastoreRpc;
import com.google.datastore.v1.AggregationQuery;
import com.google.datastore.v1.AggregationQuery.Aggregation;
import com.google.datastore.v1.AggregationQuery.Aggregation.Count;
import com.google.datastore.v1.EntityResult;
import com.google.datastore.v1.Filter;
import com.google.datastore.v1.KindExpression;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.PropertyFilter;
import com.google.datastore.v1.PropertyFilter.Operator;
import com.google.datastore.v1.PropertyReference;
// import com.google.datastore.v1.Query;
import com.google.datastore.v1.Query;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import com.google.datastore.v1.Value;
import com.google.protobuf.Int64Value;
import java.util.List;

public class DatastorePlayGround {
    public static void main(String[] args) {
        DatastoreOptions datastoreOptions = DatastoreOptions.getDefaultInstance();
        // Datastore datastore = datastoreOptions.getService();
        // EntityQuery selectAllQuery = Query.newEntityQueryBuilder()
        //     .setNamespace("1660851506815")
        //     .setKind("Character")
        //     .build();
        // QueryResults<Entity> results = datastore.run(selectAllQuery);
        // while (results.hasNext()) {
        //     Entity entity = results.next();
        //     System.out.println("Value is: " + entity.getKey());
        // }

        System.out.println("**************** key query start ****************");
        KeyQuery keyQuery = com.google.cloud.datastore.Query.newKeyQueryBuilder()
            .setKind("Character")
            .setNamespace("1660851506815")
            .build();

        QueryResults<Key> keyQueryResults = datastoreOptions.getService().run(keyQuery);

        while (keyQueryResults.hasNext()) {
            System.out.println(keyQueryResults.next());
        }
        System.out.println("**************** key query end ****************");

        System.out.println("**************** projection query start ****************");

      ProjectionEntityQuery projectionQuery = com.google.cloud.datastore.Query.newProjectionEntityQueryBuilder()
          .setKind("Character")
          .setNamespace("1660851506815")
          .addProjection("name")
          .build();

      QueryResults<ProjectionEntity> projectionEntityQueryResults = datastoreOptions.getService().run(projectionQuery);

      while (projectionEntityQueryResults.hasNext()){
        System.out.println(projectionEntityQueryResults.next().getProperties());
      }

      System.out.println("**************** projection query end ****************");

        //Regular Select Query
        DatastoreRpc datastoreRpc = new HttpDatastoreRpc(datastoreOptions);
        PartitionId partitionId = PartitionId.newBuilder().setNamespaceId("1660851506815")
            .setProjectId(datastoreOptions.getProjectId()).build();

        com.google.datastore.v1.Query selectAllCharacterQuery = com.google.datastore.v1.Query.newBuilder()
            .addKind(KindExpression.newBuilder().setName("Character").build())
            .setFilter(Filter.newBuilder().setPropertyFilter(PropertyFilter.newBuilder().setProperty(PropertyReference.newBuilder().setName("name").build()).setOp(Operator.NOT_EQUAL).setValue(Value.newBuilder().setStringValue("Catelyn").build()).build()).build())
            .build();
        RunQueryRequest runqueryRequest = RunQueryRequest.newBuilder()
            .setPartitionId(partitionId)
            .setQuery(selectAllCharacterQuery)
            .build();
        RunQueryResponse runQueryResponse = datastoreRpc.runQuery(runqueryRequest);
        List<EntityResult> entityResultsList = runQueryResponse.getBatch().getEntityResultsList();
        for (EntityResult entityResult : entityResultsList) {
            System.out.println("Value is: " + entityResult.getEntity().getPropertiesMap().get("name"));
        }

        //Count aggregation over select Query (with and without upTo)
        Count count = Count.newBuilder()
            .setUpTo(Int64Value.of(6))
            .build();
        Aggregation countAggregation = Aggregation.newBuilder().setCount(count).setAlias("total_count").build();
        AggregationQuery aggregationQuery = AggregationQuery.newBuilder()
            .addAggregations(countAggregation)
            .setNestedQuery(selectAllCharacterQuery)
            .build();

        RunAggregationQueryRequest runAggregationQueryRequest = RunAggregationQueryRequest.newBuilder()
            .setAggregationQuery(aggregationQuery)
            .setPartitionId(partitionId)
            .build();

        RunAggregationQueryResponse runAggregationQueryResponse = datastoreRpc.runAggregationQuery(runAggregationQueryRequest);

        System.out.println(runAggregationQueryResponse.getBatch().getAggregationResults(0).getAggregatePropertiesMap());

    }
}