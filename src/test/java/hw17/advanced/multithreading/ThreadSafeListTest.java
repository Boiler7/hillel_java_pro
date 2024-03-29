package hw17.advanced.multithreading;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreadSafeListTest {
    private final List<String> list = new ArrayList<>();
    private final ThreadSafeList<String> target = new ThreadSafeList<>(list);

    @Test
    void add() {
        target.add("Car");

        assertNotNull(target.get(0));
        assertTrue( target.getList().contains("Car"));
    }

    @Test
    void remove() {
        target.add("Car1");
        target.remove(0);

        assertEquals(0, target.size());
    }

    @Test
    void get() {
        target.add("Car2");

        assertEquals("Car2", target.get(0));
    }
}