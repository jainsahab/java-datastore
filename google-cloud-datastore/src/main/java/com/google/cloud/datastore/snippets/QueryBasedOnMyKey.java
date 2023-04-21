package com.google.cloud.datastore.snippets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;

public class QueryBasedOnMyKey {

  public static void main(String[] args) {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");

    Key key = keyFactory.newKey("sampleTask");

    Entity entity = datastore.get(key);

    System.out.println(entity);
  }

}
