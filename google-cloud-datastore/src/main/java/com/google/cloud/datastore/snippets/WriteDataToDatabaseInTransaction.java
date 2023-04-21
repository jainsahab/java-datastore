package com.google.cloud.datastore.snippets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Datastore.TransactionCallable;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.DatastoreReaderWriter;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import java.time.LocalDateTime;
import java.util.Date;

public class WriteDataToDatabaseInTransaction {

  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Entity insertedEntity = datastore.runInTransaction(transaction -> {
      Key taskKey = datastore.newKeyFactory().setKind("Task").newKey("sampleTask");
      Entity task = Entity.newBuilder(taskKey)
          .set("category", "Personal")
          .set("done", false)
          .set("priority", 4)
          .set("description", "Learn Cloud Datastore")
          .set("from", "handwritten library")
          .set("mode", "inside transaction @ " + now)
          .build();
      return transaction.put(task);
    });
    System.out.println(insertedEntity);
  }
}
