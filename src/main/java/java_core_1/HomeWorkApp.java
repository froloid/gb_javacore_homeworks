package java_core_1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int base = 100;
        int a = (int) ((Math.random() - 0.5) * 2 * base);
        int b = (int) ((Math.random() - 0.5) * 2 * base);

        int sum = a + b;

        String message = "Сумма ";

        if (sum >= 0) {
            message += "положительная";
        } else {
            message += "отрицательная";
        }

        System.out.println(message);
    }

    public static void printColor() {
        int base = 1000;
        int value = (int) ((Math.random() - 0.5) * 2 * base);

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int base = 100;
        int a = (int) ((Math.random() - 0.5) * 2 * base);
        int b = (int) ((Math.random() - 0.5) * 2 * base);

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
