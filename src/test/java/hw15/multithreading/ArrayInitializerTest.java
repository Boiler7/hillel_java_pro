package hw15.multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayInitializerTest {

    @Test
    void init() {

        double[] array = {2, 2, 2, 2, 2, 2};
        double[] array2 = {2, 2, 2, 2, 2, 2};

        ArrayInitializer.init(array);
        ArrayInitializer.init(array2);

        for(int i = 0; i<array.length; i++) {
            assertNotEquals(2, array[i]);
        }
    }
}