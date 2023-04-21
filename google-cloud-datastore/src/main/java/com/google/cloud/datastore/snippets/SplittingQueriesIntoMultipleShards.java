package com.google.cloud.datastore.snippets;

import com.google.datastore.v1.Filter;
import com.google.datastore.v1.KindExpression;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.PropertyFilter.Operator;
import com.google.datastore.v1.PropertyReference;
import com.google.datastore.v1.Query;
import com.google.datastore.v1.Value;
import com.google.datastore.v1.client.Datastore;
import com.google.datastore.v1.client.DatastoreException;
import com.google.datastore.v1.client.DatastoreFactory;
import com.google.datastore.v1.client.DatastoreHelper;
import com.google.datastore.v1.client.DatastoreOptions;
import java.util.List;

public class SplittingQueriesIntoMultipleShards {

  public static void main(String[] args) throws DatastoreException {
    Datastore datastore = DatastoreFactory.get().create(new DatastoreOptions.Builder().build());
    String projectId = "jainsahab-feature-development";
    PartitionId partitionId = PartitionId.newBuilder().setProjectId(projectId).build();

    Filter.Builder filter = Filter.newBuilder()
        .setPropertyFilter(
            com.google.datastore.v1.PropertyFilter.newBuilder()
                .setProperty(PropertyReference.newBuilder().setName("done").build())
                .setOp(Operator.EQUAL)
                .setValue(Value.newBuilder().setBooleanValue(true).build()));

    Query query = Query.newBuilder()
        .addKind(KindExpression.newBuilder().setName("Task").build())
        .setFilter(filter)
        .build();

    List<Query> splittedQueries = DatastoreHelper.getQuerySplitter()
        .getSplits(query, partitionId, 3, datastore);

    // execute each query from 'splittedQueries' in parallel
  }

}
