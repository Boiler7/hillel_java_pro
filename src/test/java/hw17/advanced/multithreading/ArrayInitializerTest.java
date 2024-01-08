package hw17.advanced.multithreading;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayInitializerTest {

    @Test
    void compute() {
        int size = 100;
        double[] data = new double[size];
        Arrays.fill(data, 2);
        var initializer = new ArrayInitializer(data, 0, size-1);

        var result = initializer.compute();

        assertNotNull(result);

        for (int i = 0; i < size-1; i++) {
            assertNotEquals(2, result[i]);
        }
    }
}