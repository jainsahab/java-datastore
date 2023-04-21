package com.google.cloud.datastore.snippets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;

public class WriteDataToDatabase {

  public static void main(String[] args) {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Key taskKey = datastore.newKeyFactory().setKind("Task").newKey("sampleTask");
    Entity task = Entity.newBuilder(taskKey)
        .set("category", "Personal")
        .set("done", false)
        .set("priority", 4)
        .set("description", "Learn Cloud Datastore")
        .set("from", "handwritten library")
        .build();

    Entity entity = datastore.put(task);
    System.out.println(entity);
  }

}
