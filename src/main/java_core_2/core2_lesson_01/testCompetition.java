package core1_lesson_01;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class testCompetition {

    public static void main(String... args) {
        float runBase = 20;
        float jumpBase = 3;
        int variationRate = 25;
        int obstaclesCount = 10;

        Competition competition = new Competition(10, 20, 3, 25);

        Human human = new Human(runBase, jumpBase, variationRate);
        Cat cat = new Cat(runBase, jumpBase, variationRate);
        Robot robot = new Robot(runBase, jumpBase, variationRate);

        int humanRes = competition.tryOvercome(human, "human Dmitri");
        int catRes = competition.tryOvercome(cat, "cat Naida");
        int robotRes = competition.tryOvercome(robot, "robot Froloid");

        System.out.printf("Human result: %s, cat result: %s, robot result: %s\n", humanRes, catRes, robotRes);
    }
}
