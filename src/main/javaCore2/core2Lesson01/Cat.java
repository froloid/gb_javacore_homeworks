package core2Lesson01;

public class Cat implements Runable, Jumpable {
    private float jumpRate;
    private float runRate;
    private int variationRate;

    public Cat(float baseRateRun, float baseRateJump, int variation) {
        this.variationRate = variation;
        this.jumpRate = baseRateJump;
        this.runRate = baseRateRun;
    }

    public float run() {
        float runLength = runRate + runRate * ((float) Math.random() - 0.5F) * 2 * variationRate / 100;
        System.out.printf("The cat ran %.2f metres \n", runLength);
        return runLength;
    }

    public float jump() {
        float jumpHeight = jumpRate + jumpRate * ((float) Math.random() - 0.5F) * 2 * variationRate / 100;
        System.out.printf("The cat jumped %.2f metres \n", jumpHeight);
        return jumpHeight;
    }
}

