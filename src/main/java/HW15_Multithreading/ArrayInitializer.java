package HW15_Multithreading;

import java.util.Arrays;

public class ArrayInitializer {
    public static void init(double[] array){
        int n = array.length;

        double[] a = Arrays.copyOfRange(array, 0, (n + 1)/2);
        double[] b = Arrays.copyOfRange(array, (n + 1)/2, n);

        var thread1 = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                a[i] = (a[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
            }
        });

        var thread2 = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                b[i] = (b[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
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
        for(int i = 0; i < b.length; i++) {
            array[i] = b[n / 2 + i];
        }
    }
}
