package com.google.cloud.datastore.snippets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import java.util.List;

public class ReserveIDsForAKey {

  public static void main(String[] args) {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");
    Key key1 = keyFactory.newKey(10); // reserving a numeric ID
    Key key2 = keyFactory.newKey("name"); // reserving a string id
    List<Key> keys = datastore.reserveIds(key1, key2);

    System.out.println(keys);
  }

}
