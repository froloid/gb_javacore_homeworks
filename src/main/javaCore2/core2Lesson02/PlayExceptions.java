package core2Lesson02;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PlayExceptions {

    public static int calculateStringArraySum(String[][] testArray)
                        throws MyArraySizeException {
        int firstDimension = testArray.length;
        int secondDimension = testArray[0].length;
        if (firstDimension != 2 || secondDimension != 2)
            throw new MyArraySizeException(String
                    .format("Получен массив формы %dх%d (%s) вместо требуемого 2х2."
                            , firstDimension, secondDimension, Arrays.deepToString(testArray)));
        int sum = 0;

        for (String[] nestedArray : testArray) {
            for (String element : nestedArray) {
                try {
                    sum += Integer.valueOf(element);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("Строки в массиве должны иметь числовой формат (получен массив %s)."
                            , Arrays.deepToString(testArray)));
                }
            }
        }

        return sum;
    }

    public static void main(String... args) {
        String[][] inputArray1 = {{"16", "0", "-1"}, {"9", "14", "-5"}};
        String[][] inputArray2 = {{"16", "-1"}, {"9", "one"}};
        String[][] inputArray3 = {{"16", "0"}, {"9", "-5"}};

        tryCalculate(inputArray1);
        tryCalculate(inputArray2);
        tryCalculate(inputArray3);
    }

    private static void tryCalculate(String[][] inputArray) {
        try {
            System.out.printf("Сумма элементов массива %s равна: %s."
                    , Arrays.deepToString(inputArray), calculateStringArraySum(inputArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    public static class MyArrayDataException extends NumberFormatException {
        public MyArrayDataException(String message) {
            super(message);
        }
    }
}

