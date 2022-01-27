package core2Lesson05;

import java.util.Arrays;

public class MultiThreadSandbox {

    public static void singleThreadHandle(float[] arr) {
        long a = System.currentTimeMillis();

        HandlingArray arrayHandler = new HandlingArray(arr);
        arrayHandler.run();

        long b = System.currentTimeMillis();

        System.out.printf("singleThreadHandle метод обработал массив за %d миллисекунд\n", b - a);

    }

    public static void doubleThreadHandle(float[] arr) {

        long a = System.currentTimeMillis();

        var h = arr.length / 2;
        var arrHead = new float[h];
        System.arraycopy(arr, 0, arrHead, 0, h);
        var arrTail = new float[h];
        System.arraycopy(arr, h, arrTail, 0, h);

        Thread t1 = new Thread(new HandlingArray(arrHead));
        Thread t2 = new Thread(new HandlingArray(arrTail, h));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.exit(0);
        }

        System.arraycopy(arrHead, 0, arr, 0, h);
        System.arraycopy(arrTail, 0, arr, h, h);

        long b = System.currentTimeMillis();

        System.out.printf("doubleThreadHandle метод обработал массив за %d миллисекунд\n", b - a);

        System.out.println("Элементов в массиве: " + arr.length);
    }

    public static void main(String[] args) {
        int size = (int) Math.pow(10, 7);
        int h = size / 2;
        float[] arr = new float[size];
        Arrays.fill(arr, 1f);
        float[] arrClone = arr.clone();

        singleThreadHandle(arr);
        doubleThreadHandle(arrClone);

        System.out.println("Результирующие массивы: " + (Arrays.equals(arr, arrClone) ? "идентичны" : "НЕ идентичны!"));
    }
}
