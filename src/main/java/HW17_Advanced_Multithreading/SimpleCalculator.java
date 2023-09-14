package HW17_Advanced_Multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class SimpleCalculator {
    public CompletableFuture<Integer> squareSum(int first, int second) {
        CompletableFuture<Integer> firstSquareFuture = CompletableFuture.supplyAsync(() -> first * first);
        CompletableFuture<Integer> secondSquareFuture = CompletableFuture.supplyAsync(() -> second * second);

        return firstSquareFuture
                .thenCombine(secondSquareFuture, (result1, result2) -> result1 + result2);
    }
}
