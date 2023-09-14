package HW17_Advanced_Multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    void squareSum() {
        var simpleCalc = new SimpleCalculator();

        CompletableFuture<Integer> resultFuture = simpleCalc.squareSum(5, 10);

        try {
            int result = resultFuture.get();
            assertEquals(125, result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}