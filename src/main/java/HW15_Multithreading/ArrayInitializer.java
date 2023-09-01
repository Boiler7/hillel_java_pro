package HW15_Multithreading;

import java.util.Arrays;

public class ArrayInitializer {
    public static void init(double[] array){
        int length = array.length;
        int mid = length/2;


        var thread1 = new Thread(() -> {
            for (int i = 0; i < mid; i++) {
                array[i] = (array[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
            }
        });

        var thread2 = new Thread(() -> {
            for (int i = mid; i < length; i++) {
                array[i] = (array[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
