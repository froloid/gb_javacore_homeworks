package core1_lesson_01;

public class Track {
    private float length;

    Track(float base_length) {
        int variation = 25;
        this.length = base_length + base_length * ((float) Math.random() - 0.5F) * 2 * variation / 100;
    }

    public float getLength() {
        return length;
    }

    public boolean tryOvercameObstacle(Runable sportsman) {
        return sportsman.run() >= length;
    }
}