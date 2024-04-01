package hw17.advanced.multithreading;

import java.util.concurrent.RecursiveTask;

public class ArrayInitializer extends RecursiveTask<double[]> {
    private final double[] data;
    private final int start;
    private final int end;

    public ArrayInitializer(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected double[] compute() {
        if (end - start <= 100) {
            double[] data1 = new double[end - start];
            for (int i = start; i < end; i++) {
                data1[i - start] = (data[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
            }
            return data1;
        } else {
            int middle = (start + end) / 2;
            var left = new ArrayInitializer(data, start, middle);
            var right = new ArrayInitializer(data, middle, end);
            left.fork();
            right.fork();

            double[] leftResult = left.join();
            double[] rightResult = right.join();

            return concatenateArrays(leftResult, rightResult);
        }
    }

    private double[] concatenateArrays(double[] left, double[] right) {
        double[] result = new double[left.length + right.length];
        System.arraycopy(left, 0, result, 0, left.length);
        System.arraycopy(right, 0, result, left.length, right.length);
        return result;
    }
}
