package com.google.cloud.datastore.snippets;

import static com.google.cloud.datastore.Query.ResultType.ENTITY;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.GqlQuery;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;

public class GqlQueryBasedOnFilter {

  public static void main(String[] args) {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    GqlQuery<Entity> gqlQuery = Query.newGqlQueryBuilder(ENTITY,
        "SELECT * FROM Task where priority = 4")
        .setAllowLiteral(true)
        .build();
    QueryResults<Entity> results = datastore.run(gqlQuery);

    while (results.hasNext()){
      System.out.println(results.next());
    }
  }

}
