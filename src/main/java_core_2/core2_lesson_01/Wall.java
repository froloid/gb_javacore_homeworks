package core1_lesson_01;

import jdk.jfr.Frequency;

public class Wall {
    private float height;

    Wall(float base_height) {
        int variation = 25;
        this.height = base_height + base_height * ((float) Math.random() - 0.5F) * 2 * variation / 100;
    }

    public float getHeight() {
        return height;
    }

    public boolean tryOvercameObstacle(Jumpable sportsman) {
        return sportsman.jump() >= height;
    }
}
