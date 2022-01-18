package core2Lesson01;

public class Robot implements Runable, Jumpable {
    private float jumpRate;
    private float runRate;
    private int variationRate;

    public Robot(float baseRateRun, float baseRateJump, int variation) {
        this.variationRate = variation;
        this.jumpRate = baseRateJump;
        this.runRate = baseRateRun;
    }

    public float run() {
        float runLength = runRate + runRate * ((float) Math.random() - 0.5F) * 2 * variationRate / 100;
        System.out.printf("The robot ran %.2f metres \n", runLength);
        return runLength;
    }

    public float jump() {
        float jumpHeight = jumpRate + jumpRate * ((float) Math.random() - 0.5F) * 2 * variationRate / 100;
        System.out.printf("The robot jumped %.2f metres \n", jumpHeight);
        return jumpHeight;
    }
}
