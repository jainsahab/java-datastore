package com.google.cloud.datastore.snippets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;

public class ReserveNumericIDForKey {

  public static void main(String[] args) {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");

    Key taskKey = datastore.allocateId(keyFactory.newKey(4567890));

    System.out.println(taskKey);
  }

}
