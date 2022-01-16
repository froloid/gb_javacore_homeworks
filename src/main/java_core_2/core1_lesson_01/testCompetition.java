package core1_lesson_01;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class competition <T extends Runable & Jumpable> {

    public int tryOvercame(T sportsmen, ArrayList<Object> obstacles) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("sdfljk");

        return 0;
    };

    public static ArrayList<Object> createTrack(float runBase, float jumpBase, int count) {
        ArrayList<Object> obstacles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int index = (int) Math.round(Math.random());
            obstacles.add(index == 1 ? new Track(runBase) : new Wall(jumpBase));
        }
        return obstacles;
    }

    public static void main(String... args) {
        float runBase = 20;
        float jumpBase = 3;
        int variationRate = 25;
        int obstaclesCount = 10;

        ArrayList<Object> track = createTrack(runBase, jumpBase, obstaclesCount);

        Human human = new Human(runBase, jumpBase, variationRate);

    }

    public int tryOvercome(T sportsmen, ArrayList<Object> track, String sportsmenNiсk) {

        int overcameCount = 0;

        for (Object obstacle:track) {
            if (obstacle instanceof Track) {
                System.out.printf("length of track: %.2f \n", ((Track) obstacle).getLength());
                overcameCount += ((Track) obstacle).tryOvercameObstacle(sportsmen) ? 1 : 0;
            }
            else if (obstacle instanceof Wall) {
                System.out.printf("height of wall: %.2f \n", ((Wall) obstacle).getHeight());
                overcameCount += ((Wall) obstacle).tryOvercameObstacle(sportsmen) ? 1 : 0;
            }
        }

        System.out.printf("The %s overcame %d from %d obstacles", sportsmenNiсk, overcameCount, track.size());
        return overcameCount;
    }
}
