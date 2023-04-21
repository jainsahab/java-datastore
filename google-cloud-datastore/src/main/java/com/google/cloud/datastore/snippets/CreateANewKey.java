package com.google.cloud.datastore.snippets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;

public class CreateANewKey {

  public static void main(String[] args) {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");

    Key keyWithNumericId = keyFactory.newKey(389239043);
    Key keyWithStringId = keyFactory.newKey("sampleTask");

    Key autoAssignedIntegerNumericId = datastore.allocateId(keyFactory.newKey());
  }

}
