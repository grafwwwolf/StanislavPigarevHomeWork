public class HomeWorkApp {

    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 101;
        int b = -1101;
        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
//        Вариант второй:
//       String result = (a + b) >= 0 ? "Сумма положительная" : "Сумма отрицательная";
//        System.out.println(result);
    }

    public static void printColor() {

        int value = 101;

        if (value <= 0) {
            System.out.println("Красный");
        }
        else if ((value > 0) && (value <= 100)) {
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 101;
        int b = 101;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
//        Вариант второй:)
//       String result = (a >= b) ? "a >= b" : "a < b";
//        System.out.println(result);
    }
}