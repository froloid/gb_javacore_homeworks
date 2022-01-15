public class HomeWorkApp {
    public static void main(String[] args) {

        int testNumber1 = (int) ((Math.random() - 0.5) * 2 * 100);
        int testNumber2 = (int) ((Math.random() - 0.5) * 2 * 100);
        int logCount = (int) (Math.random() * 10) + 1;

        String yesNoText = checkSumInterval(testNumber1, testNumber2) ? "" : "does not";
        System.out.printf("sum of %d and %d %s belongs to the interval [%d, %d]\n", testNumber1, testNumber2, yesNoText, 10, 20);
        logSignNumber(testNumber1);
        multipleLogInfo("some information", logCount);
        
        int[] testYears = {300, 400, 47, 48};

        System.out.println("test leap func:");

        for (int year : testYears) {
            System.out.printf("    test year %d: result - the year is %sleap\n", year, isLeapYear(year) ? "" : "not ");
        }
    }

    public static boolean checkSumInterval(int number1, int number2, int leftBoundary, int rightBoundary) {
        int sum = number1 + number2;

        return sum >= leftBoundary & sum <= rightBoundary;
    }

    public static boolean checkSumInterval(int number1, int number2) {
        return checkSumInterval(number1, number2, 10, 20);
    }

    public static void logSignNumber(int number) {
        String result = "negative";

        if (checkSignNumber(number)) {
            result = "positive";
        }

        System.out.printf("the number %s is %s\n", number, result);
    }

    public static boolean checkSignNumber(int number) {

        return number >= 0;
    }

    public static void multipleLogInfo(String textInfo, int logCount) {
        for (int i = 0; i < logCount; i++) {
            System.out.println(textInfo);

        }
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || year % 100 != 0 & year % 4 == 0;
    }
}
