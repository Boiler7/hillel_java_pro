package hw17.advanced.multithreading;

import java.util.concurrent.CompletableFuture;


public class SimpleCalculator {
    public CompletableFuture<Integer> squareSum(int first, int second) {
        CompletableFuture<Integer> firstSquareFuture = CompletableFuture.supplyAsync(() -> first * first);
        CompletableFuture<Integer> secondSquareFuture = CompletableFuture.supplyAsync(() -> second * second);

        return firstSquareFuture
                .thenCombine(secondSquareFuture, (result1, result2) -> result1 + result2);
    }
}
