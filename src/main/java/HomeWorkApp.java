import java.lang.reflect.Array;
import java.util.Arrays;

public class HomeWorkApp {

    public static void main(String[] args) {

//       1.
        int[] myArray = {1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0};
        changeArray(myArray);
//       2.
        int[] secondArray = new int[100];
        secondArray = completionArray(secondArray);
//       3.
        int[] thirdArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeArrayForTask3(thirdArray);
//       4.
        int[][] squareArray = new int[8][8];
        completionArray(squareArray);
        printSquareArray(squareArray);
//       5.
        int[] fifthArray = completionArray(3, -63);
//       6. *
        findMinAndMaxValuesOfArray(thirdArray);
//       7. *
        System.out.println(checkBalance(thirdArray));
//       8. ***
        moveArray(thirdArray, -2);
    }

    //    принт двумерного массива
    public static void printSquareArray(int[][] squareArray) {
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray.length; j++) {
                System.out.print(squareArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    //    метод к заданию 1
    public static void changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }

    //    метод к заданию 2
    public static int[] completionArray(int[] array) {
        int[] localArray = new int[array.length];
        for (int i = 0; i < localArray.length; i++) {
            localArray[i] = i + 1;
        }
        return localArray;
    }

    //    метод к заданию 3
    public static void changeArrayForTask3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    //    метод к заданию 4
    public static void completionArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - (i + 1)] = 1;
        }
    }

    //    метод к заданию 5
    public static int[] completionArray(int len, int initialValue) {
        int[] localArray = new int[len];
        for (int i = 0; i < localArray.length; i++) {
            localArray[i] = initialValue;
        }
        return localArray;
    }

    //    метод к заданию 6
    public static void findMinAndMaxValuesOfArray(int[] array) {
        if (array.length == 0) {
            System.out.println("Массив пустой");
            return;
        }

        int minValue = array[0];
        int maxValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        System.out.println("Минимальное значение массива " + " равно " + minValue);
        System.out.println("Максимальное значение массива " + " равно " + maxValue);
    }

    //    метод к заданию 7
    public static boolean checkBalance(int[] array) {
        int a = array.length - 1;
        int b = 1;
        int leftSum = array[0];
        int rightSum = array[a];

        for (int i = 1; i < array.length - 1; i++) {
            if (leftSum <= rightSum) {
                leftSum += array[b++];
            } else {
                rightSum += array[--a];
            }
        }
        return leftSum == rightSum;
    }

    //    метод к заданию 8
    public static void moveArray(int[] array, int n) {
        if (array.length == 0 || array.length == 1 || n == 0 || n % array.length == 0) {
            return;
        }
        if (n > array.length) {
            n %= array.length;
        }
        if (n > 0) {
            for (; n > 0; n--) {
                moveArrayPlus(array);
            }
        } else {
            for (; n < 0; n++) {
                moveArrayMinus(array);
            }
        }
    }
//    доп методы к заданию 8

    private static void moveArrayPlus(int[] array) {
        int variable = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = variable;
    }

    private static void moveArrayMinus(int[] array) {
        int variable = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = variable;
    }
}
