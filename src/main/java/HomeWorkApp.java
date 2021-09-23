
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {

    private static char[][] map;
    private static final char X_DOT = 'X';
    private static final char O_DOT = 'O';
    private static final char EMPTY_DOT = '•';
    private static final int mapSize = 5;
    private static final int POINTS_TO_WIN = 4;
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {

        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (isWin(X_DOT)) {
                System.out.println("YOU WIN");
                break;
            }
            if (isDraw()) {
                break;
            }
            computerTurn();
            printMap();
            if (isWin(O_DOT)) {
                System.out.println("YOU LOSE");
                break;
            }
            if (isDraw()) {
                break;
            }
        }

    }

    private static boolean isWin(char dot) {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (checkRight(i, j, dot)) {
                    return true;
                }
                if (checkDown(i, j, dot)) {
                    return true;
                }
                if (checkRightDown(i, j, dot)) {
                    return true;
                }
                if (checkRightUp(i, j, dot)) {
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean checkRight(int i, int j, char dot) {
        if (j > map.length - POINTS_TO_WIN) {
            return false;
        }
        for (int k = 0; k < POINTS_TO_WIN; k++) {
            if (map[i][j] == dot) {
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDown(int i, int j, char dot) {
        if (i > map.length - POINTS_TO_WIN) {
            return false;
        }
        for (int k = 0; k < POINTS_TO_WIN; k++) {
            if (map[i][j] == dot) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRightDown(int i, int j, char dot) {
        if ((i > map.length - POINTS_TO_WIN) || (j > map.length - POINTS_TO_WIN)) {
            return false;
        }
        for (int k = 0; k < POINTS_TO_WIN; k++) {
            if (map[i][j] == dot) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRightUp(int i, int j, char dot) {
        if ((i < POINTS_TO_WIN - 1) || (j > map.length - POINTS_TO_WIN)) {
            return false;
        }
        for (int k = 0; k < POINTS_TO_WIN; k++) {
            if (map[i][j] == dot) {
                i--;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }


    private static void humanTurn() {
        int xCoordinate;
        int yCoordinate;
        System.out.println("Введите координаты в формате \"x пробел y\"");
        do {
            xCoordinate = -1;
            yCoordinate = -1;

            if (SC.hasNextInt()) {
                xCoordinate = SC.nextInt();
            }
            if (SC.hasNextInt()) {
                yCoordinate = SC.nextInt();
            }
            SC.nextLine();
        } while (!isValidHumanTurn(xCoordinate, yCoordinate));
    }

    private static void computerTurn() {
        System.out.println("Ходит компьютер");
        int xCoordinate;
        int yCoordinate;
        Random random = new Random();
        do {
            xCoordinate = random.nextInt(mapSize);
            yCoordinate = random.nextInt(mapSize);
        } while (!isValidComputerTurn(xCoordinate, yCoordinate));
    }

    private static boolean isValidHumanTurn(int xCoordinate, int yCoordinate) {
        if (xCoordinate < 1 || yCoordinate < 1 ||
                xCoordinate > mapSize || yCoordinate > mapSize) {
            System.out.println("Вы ввели неправильные координаты. Введите координаты в формате \"x пробел y\"");
            return false;
        }

        if (map[xCoordinate - 1][yCoordinate - 1] == EMPTY_DOT) {
            map[xCoordinate - 1][yCoordinate - 1] = X_DOT;
            return true;
        }
        System.out.println("Вы ввели неправильные координаты. Введите координаты в формате \"x пробел y\"");
        return false;
    }

    private static boolean isValidComputerTurn(int xCoordinate, int yCoordinate) {
        if (map[xCoordinate][yCoordinate] == EMPTY_DOT) {
            map[xCoordinate][yCoordinate] = O_DOT;
            return true;
        }
        return false;
    }

    private static void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void initMap() {
        map = new char[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            Arrays.fill(map[i], EMPTY_DOT);
        }
    }

    private static boolean isDraw() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        System.out.println("DRAW");
        return true;
    }
}
