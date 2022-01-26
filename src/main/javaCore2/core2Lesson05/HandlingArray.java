package core2Lesson05;

public class HandlingArray implements Runnable {
    private float[] arr;

    public HandlingArray(float[] myArr) {
        this.arr = myArr;
    }

    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.f + i / 5)
                    * Math.cos(0.4f  + i / 2));
        }
    }
}
