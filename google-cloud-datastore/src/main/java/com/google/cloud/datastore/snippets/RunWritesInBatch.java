package com.google.cloud.datastore.snippets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.Key;
import java.util.Arrays;
import java.util.List;

public class RunWritesInBatch {

  public static void main(String[] args) {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Key key1 = datastore.newKeyFactory().setKind("Task").newKey("sampleTask1");
    Key key2 = datastore.newKeyFactory().setKind("Task").newKey("sampleTask2");
    FullEntity<Key> task1 =
        Entity.newBuilder(key1)
            .set("category", "Personal")
            .set("done", false)
            .set("priority", 4)
            .set("description", "Learn Cloud Datastore")
            .set("from", "handwritten library")
            .build();
    FullEntity<Key> task2 =
        Entity.newBuilder(key2)
            .set("category", "Personal")
            .set("done", false)
            .set("priority", 5)
            .set("description", "Integrate Cloud Datastore")
            .set("from", "handwritten library")
            .build();
    List<Entity> tasks = datastore.put(task1, task2);
    Key taskKey1 = tasks.get(0).getKey();
    Key taskKey2 = tasks.get(1).getKey();
    System.out.println(Arrays.asList(taskKey1, taskKey2));
  }

}
