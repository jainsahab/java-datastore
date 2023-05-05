package com.google.cloud.datastore.it;

import static com.google.cloud.datastore.aggregation.Aggregation.avg;
import static com.google.cloud.datastore.aggregation.Aggregation.sum;
import static com.google.common.collect.Iterables.getOnlyElement;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.proxy.EmulatorProxy;
import com.google.cloud.datastore.testing.RemoteDatastoreHelper;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class ITDatastoreAggregationsTest {

  private static final RemoteDatastoreHelper HELPER = RemoteDatastoreHelper.create();
  private static final DatastoreOptions OPTIONS = HELPER.getOptions();
  private static final Datastore DATASTORE = OPTIONS.getService();

  private static final EmulatorProxy emulatorProxy = new EmulatorProxy(OPTIONS);

  //TODO(jainsahab): delete it and delegate all calls to DATASTORE when backend is ready
  private static final Datastore datastoreEmulatorProxy = emulatorProxy.getOptions().getService();

  private static final String KIND = "Marks";

  @After
  public void tearDown() {
    EntityQuery allEntitiesQuery = Query.newEntityQueryBuilder().build();
    QueryResults<Entity> allEntities = DATASTORE.run(allEntitiesQuery);
    Key[] keysToDelete =
        ImmutableList.copyOf(allEntities).stream().map(Entity::getKey).toArray(Key[]::new);
    DATASTORE.delete(keysToDelete);
  }

  @AfterClass
  public static void afterClass() throws IOException {
    emulatorProxy.stop();
  }

  Key key1 = DATASTORE.newKeyFactory().setKind(KIND).newKey(1);
  Key key2 = DATASTORE.newKeyFactory().setKind(KIND).newKey(2);
  Key key3 = DATASTORE.newKeyFactory().setKind(KIND).newKey(3);

  Entity entity1 = Entity.newBuilder(key1)
      .set("name", "Jon Stark")
      .set("marks", 89)
      .set("cgpa", 7.34)
      .build();
  Entity entity2 = Entity.newBuilder(key2)
      .set("name", "Arya Stark")
      .set("marks", 95)
      .set("cgpa", 9.27)
      .build();
  Entity entity3 = Entity.newBuilder(key3)
      .set("name", "Night king")
      .set("marks", 55)
      .set("cgpa", 5.16)
      .build();

  @Test
  public void testAggregationQueryWithSumAggregation() {
    DATASTORE.put(entity1, entity2);

    EntityQuery baseQuery = Query.newEntityQueryBuilder()
        .setKind(KIND)
        .build();
    AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
        .over(baseQuery)
        .addAggregations(sum("marks").as("total_marks"))
        .setNamespace(OPTIONS.getNamespace())
        .build();

    // sum of 2 entities
    assertThat(getOnlyElement(
        datastoreEmulatorProxy.runAggregation(aggregationQuery)).get("total_marks")).isEqualTo(
        184L);

    // sum of 3 entities
    DATASTORE.put(entity3);
    assertThat(getOnlyElement(
        datastoreEmulatorProxy.runAggregation(aggregationQuery)).get("total_marks")).isEqualTo(
        239L);
  }

  @Test
  public void testAggregationQueryWithSumAggregationResultOfDoubleType() {
    DATASTORE.put(entity1, entity2);

    EntityQuery baseQuery = Query.newEntityQueryBuilder()
        .setKind(KIND)
        .build();
    AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
        .over(baseQuery)
        .addAggregations(sum("cgpa").as("total_cgpa"))
        .setNamespace(OPTIONS.getNamespace())
        .build();

    // sum of 2 entities
    assertThat(getOnlyElement(
        datastoreEmulatorProxy.runAggregation(aggregationQuery)).getDouble("total_cgpa")).isEqualTo(
        16.61);

    // sum of 3 entities
    DATASTORE.put(entity3);
    assertThat(getOnlyElement(
        datastoreEmulatorProxy.runAggregation(aggregationQuery)).getDouble("total_cgpa")).isEqualTo(
        21.77);
  }

  @Test
  public void testAggregationQueryWithAvgAggregation() {
    DATASTORE.put(entity1, entity2);

    EntityQuery baseQuery = Query.newEntityQueryBuilder()
        .setKind(KIND)
        .build();
    AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
        .over(baseQuery)
        .addAggregations(avg("marks").as("avg_marks"))
        .setNamespace(OPTIONS.getNamespace())
        .build();

    // avg of 2 entities
    assertThat(getOnlyElement(
        datastoreEmulatorProxy.runAggregation(aggregationQuery)).getDouble("avg_marks"))
        .isEqualTo(92D);

    // avg of 3 entities
    DATASTORE.put(entity3);
    assertThat(getOnlyElement(
        datastoreEmulatorProxy.runAggregation(aggregationQuery)).getDouble("avg_marks"))
        .isEqualTo(79.66666666666667);
  }
}
