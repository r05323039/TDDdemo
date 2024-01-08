package tdd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MultiMapTest {
    @Test
    void isEmpty() {
        MultiMap map = new MultiMap();

        assertEquals(true, map.isEmpty());
    }

    @Test
    void key_size() {
        MultiMap map = new MultiMap();

        map.put(1, Arrays.asList(1, 2, 3));
        assertEquals(1, map.size());

        map.put(2, Arrays.asList(1, 2, 3));
        assertEquals(2, map.size());
    }

    @Test
    void value_size() {
        MultiMap map = new MultiMap();

        map.put(1, Arrays.asList(1, 2, 3));
        assertEquals(3, map.valueSize());

        map.put(2, Arrays.asList(1, 2, 3, 4));
        assertEquals(7, map.valueSize());
    }

    @Test
    void get_success() {
        MultiMap map = new MultiMap();

        map.put(2, Arrays.asList(1, 2, 3, 4));

        assertEquals(Arrays.asList(1, 2, 3, 4), map.get(2));
    }

    @Test
    void get_fail__Throw() {
        MultiMap map = new MultiMap();

        assertThrows(NotExistKeyException.class, () -> map.get(2));
    }
}