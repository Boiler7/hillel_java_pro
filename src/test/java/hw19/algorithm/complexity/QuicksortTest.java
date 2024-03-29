package hw19.algorithm.complexity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuicksortTest {

    @Test
    void quickSort() {
        int[] array = {9, 3, 45, 6, 0, 12, 6};
        int[] expected = Arrays.stream(array).sorted().toArray();

        Quicksort.quickSort(array, 0, array.length-1);

        assertArrayEquals(array, expected);
    }
}