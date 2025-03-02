package tech.jhipster.lite.shared.collection.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tech.jhipster.lite.UnitTest;

@UnitTest
class JHipsterCollectionsTest {

  @Nested
  @DisplayName("Collection")
  class JHipsterCollectionsCollectionTest {

    @Test
    void shouldGetEmptyImmutableCollectionFromNullCollection() {
      Collection<String> source = null;
      Collection<String> collection = JHipsterCollections.immutable(source);

      assertThat(collection).isEmpty();
      assertThatThrownBy(collection::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldGetImmutableCollectionFromCollection() {
      Collection<String> source = new ArrayList<>();
      source.add("test");
      Collection<String> collection = JHipsterCollections.immutable(source);

      assertThat(collection).containsExactly("test");
      assertThatThrownBy(collection::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }
  }

  @Nested
  @DisplayName("Map")
  class JHipsterCollectionsMapTest {

    @Test
    void shouldGetEmptyImmutableMapFromNullMap() {
      Map<String, String> source = null;
      Map<String, String> map = JHipsterCollections.immutable(source);

      assertThat(map).isEmpty();
      assertThatThrownBy(map::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldGetImmutableMapFromMap() {
      Map<String, String> source = new HashMap<>();
      source.put("key", "value");
      Map<String, String> map = JHipsterCollections.immutable(source);

      assertThat(map).containsExactly(entry("key", "value"));
      assertThatThrownBy(map::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }
  }

  @Nested
  class Concat {

    @Test
    void shouldGetEmptyCollectionFromNullCollections() {
      Collection<String> concatenedCollection = JHipsterCollections.concat((Collection<String>) null);

      assertThat(concatenedCollection).isEmpty();
    }

    @Test
    void shouldConcatCollections() {
      Collection<String> collection = JHipsterCollections.concat(List.of("first"), Set.of("second"));

      assertThat(collection).containsExactly("first", "second");
      assertThatThrownBy(collection::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldIgnoreNullInputs() {
      Collection<String> collection = JHipsterCollections.concat(List.of("first"), null);

      assertThat(collection).containsExactly("first");
    }
  }
}
