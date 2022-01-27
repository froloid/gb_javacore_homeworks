package core2Lesson05;

public class HandlingArray implements Runnable {
    private float[] arr;
    private int indexOffset;

    public HandlingArray(float[] myArr) {
        this.arr = myArr;
        this.indexOffset = 0;
    }

    public HandlingArray(float[] myArr, int myOffset) {
        this.arr = myArr;
        this.indexOffset = myOffset;
    }

    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + indexOffset) / 5) * Math.cos(0.f + (i + indexOffset) / 5)
                    * Math.cos(0.4f  + (i + indexOffset) / 2));
        }
    }
}
