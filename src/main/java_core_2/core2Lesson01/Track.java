package core2Lesson01;

public class Track {
    private float length;

    Track(float baseLength) {
        int variation = 25;
        this.length = baseLength + baseLength * ((float) Math.random() - 0.5F) * 2 * variation / 100;
    }

    public float getLength() {
        return length;
    }

    public boolean tryOvercameObstacle(Runable sportsman) {
        return sportsman.run() >= length;
    }
}