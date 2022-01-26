package core2Lesson05;

import java.util.Arrays;

public class MultiThreadSandbox {

    //public static float[] arr;

    public static void singleThreadHandle() {
        final int size = (int) Math.pow(10, 7);
        final int h = size / 2;
        float[] arr = new float[size];
        Arrays.fill(arr, 1f);

        long a = System.currentTimeMillis();

        HandlingArray arrayHandler = new HandlingArray(arr);
        arrayHandler.run();

        long b = System.currentTimeMillis();

        System.out.printf("singleThreadHandle метод обработал массив за %d миллисекунд\n", b - a);

    }

    public static void doubleThreadHandle() {
        final int size = (int) Math.pow(10, 7);
        final int h = size / 2;
        float[] arr = new float[size];
        Arrays.fill(arr, 1f);

        long a = System.currentTimeMillis();

        float[] arrHead = new float[h];
        System.arraycopy(arr, 0, arrHead, 0, h);

        float[] arrTail = new float[h];
        System.arraycopy(arr, 0, arrTail, h, arr.length);
        
        Thread t1 = new Thread(new HandlingArray(arrHead));
        Thread t2 = new Thread(new HandlingArray(arrTail));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.exit(0);
        }

        System.arraycopy(arr, 0, arrHead, 0, h);
        System.arraycopy(arr, h, arrTail, h, h);

        long b = System.currentTimeMillis();

        System.out.printf("singleThreadHandle метод обработал массив за %d миллисекунд\n", b - a);

        System.out.println("Элементов в массиве: " + arr.length);

    }

    public static void main(String... args) {
        //singleThreadHandle();
        doubleThreadHandle();
    }
}
