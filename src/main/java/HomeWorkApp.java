public class HomeWorkApp {

    public static void main(String[] args) {

        System.out.println(checkSum(5, -4));
        checkNumber(0);
        System.out.println(checkNumberBollean(1));
        printText("Some text", 1);
        System.out.println(checkLeapYear(2020));
    }

    public static boolean checkSum(int a, int b) {

        return ((10 <= a + b) && (a + b <= 20));

    }

    public static void checkNumber(int a) {
//        вариант 1
        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
//        вариант 2
//        System.out.println(a < 0 ? "Число отрицательное" : "Число положительное");
    }

    public static boolean checkNumberBollean(int a) {
        return a < 0;

    }

    public static void printText(String text, int n) {
        if (n >= 1) {
            for (int i = 0; i < n; i++) {
                System.out.println(text);
            }
        }
//        можно добавить при необходимости:
//        else {
//            System.out.println("Переданное число повторений не может быть меньше 1. Укажите верное значение.");
//        }

    }

    public static boolean checkLeapYear(int a) {
        if ((a % 400) == 0) {
            return true;
        } else if ((a % 100) == 0) { // здесь else необязательно :)
            return false;
        } else if ((a % 4) == 0) {  // здесь else необязательно
            return true;
        }
        return false;
    }
}