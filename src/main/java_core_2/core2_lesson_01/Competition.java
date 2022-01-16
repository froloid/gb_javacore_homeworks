package core1_lesson_01;

import java.util.ArrayList;

public class Competition {

    int obstaclesCount;
    float runBase;
    float jumpBase;
    int variationRate;
    ArrayList<Object> track;

    Competition(int obstaclesCount, float runBase, float jumpBase, int variationRate) {
        this.obstaclesCount = obstaclesCount;
        this.runBase = runBase;
        this.jumpBase = jumpBase;
        this.variationRate = variationRate;
        this.track = createTrack(runBase, jumpBase, obstaclesCount);
    }

    public static ArrayList<Object> createTrack(float runBase, float jumpBase, int count) {
        ArrayList<Object> obstacles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int index = (int) Math.round(Math.random());
            obstacles.add(index == 1 ? new Track(runBase) : new Wall(jumpBase));
        }
        return obstacles;
    }

    public <T extends Runable & Jumpable> int tryOvercome(T sportsmen
            , String sportsmenNick) {
        int overcameCount = 0;
        boolean abortOnFailure = true;
        boolean success = false;

        for (Object obstacle : track) {
            if (obstacle instanceof Track) {
                System.out.printf("length of track: %.2f \n", ((Track) obstacle).getLength());
                success = ((Track) obstacle).tryOvercameObstacle(sportsmen);
            } else if (obstacle instanceof Wall) {
                System.out.printf("height of wall: %.2f \n", ((Wall) obstacle).getHeight());
                success = ((Wall) obstacle).tryOvercameObstacle(sportsmen);
            }

            overcameCount += success ? 1 : 0;

            if (!success & abortOnFailure) {
                System.out.printf("The %s overcame %d from %d obstacles\n", sportsmenNick, overcameCount, track.size());
                return overcameCount;
            }
        }

        System.out.printf("The %s overcame %d from %d obstacles\n", sportsmenNick, overcameCount, track.size());
        return overcameCount;
    }
}
