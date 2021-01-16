package ru.geekbrains.javaCoreBase.homeWork;

import java.util.Scanner;

public class lesson4 {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    static int lastXDOT_X = 0;
    static int lastYDOT_X = 0;
    static int lastXDOT_O = 0;
    static int lastYDOT_O = 0;
    static int freedom = 0;
    static int freedomWithFr = 0;
    static int firstMan1Comp2 = 1;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean b = true;
        while (b) {
            initMap();
            printMap();
            boolean man = firstMan1Comp2 == 1;
            while (true) {
                if (man) {
                    humanTurn();
                    if (checkWin(DOT_X, lastXDOT_X, lastYDOT_X)) {
                        System.out.println("Победил человек");
                        break;
                    }
                } else {
                    aiTurn();
                    if (checkWin(DOT_O, lastXDOT_O, lastYDOT_O)) {
                        System.out.println("Победил Искуственный Интеллект");
                        break;
                    }
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
                man = !man;
            }
            System.out.println("Игра закончена");
            System.out.println("Сыграем снова? 1-Да/0-Нет");
            b = (sc.nextInt() == 1);
        }
    }

    public static boolean checkWin(char symb, int x, int y) {
        if (calcStep(symb, x, y) >= DOTS_TO_WIN) return true;
        else return false;
    }

    //для элемента массива с индексами x, y, для символа symb рассчитывается максимальное количество шагов до победы DOTS_TO_WIN - step ,
    // количество победных комбинаций - freedom, количество уже проставленных фищек, входящих в победные комбинации - freedomWithFr
    public static int calcStep(char symb, int x, int y) {
        int step = 0;
        int lowX = 0;
        int highX = 0;
        int lowY = 0;
        int highY = 0;
        freedom = 0;
        freedomWithFr = 0;

        if (map[y][x] == DOT_EMPTY || map[y][x] == symb) {
            //вертикаль
            lowY = highY = y;
            while (highY - y < DOTS_TO_WIN && highY < SIZE && (map[highY][x] == DOT_EMPTY || map[highY][x] == symb))
                highY++;
            highY--;

            while (y - lowY < DOTS_TO_WIN && lowY >= 0 && (map[lowY][x] == DOT_EMPTY || map[lowY][x] == symb)) lowY--;
            lowY++;

            for (int i = lowY; i <= highY - DOTS_TO_WIN + 1; i++) {
                int numberSymb = 0, numberEmpty = 0;
                for (int j = i; j < i + DOTS_TO_WIN; j++) {
                    if (map[j][x] == symb) {
                        numberSymb++;
                        freedomWithFr++;
                    }
                    if (map[j][x] == DOT_EMPTY) numberEmpty++;
                }
                if (numberSymb > 0 || numberEmpty > 0) freedom++;
                if (numberSymb > step) step = numberSymb;
            }
            //горизонталь
            lowX = highX = x;
            while (highX - x < DOTS_TO_WIN && highX < SIZE && (map[y][highX] == DOT_EMPTY || map[y][highX] == symb))
                highX++;
            highX--;

            while (x - lowX < DOTS_TO_WIN && lowX >= 0 && (map[y][lowX] == DOT_EMPTY || map[y][lowX] == symb)) lowX--;
            lowX++;

            for (int i = lowX; i <= highX - DOTS_TO_WIN + 1; i++) {
                int numberSymb = 0, numberEmpty = 0;
                for (int j = i; j < i + DOTS_TO_WIN; j++) {
                    if (map[y][j] == symb) {
                        numberSymb++;
                        freedomWithFr++;
                    }
                    if (map[y][j] == DOT_EMPTY) numberEmpty++;
                }
                if (numberSymb > 0 || numberEmpty > 0) freedom++;
                if (numberSymb > step) step = numberSymb;
            }

            //1-я диагональ
            lowX = highX = x;
            lowY = highY = y;
            while (highX - x < DOTS_TO_WIN && highX < SIZE && highY - y < DOTS_TO_WIN && highY < SIZE && (map[highY][highX] == DOT_EMPTY || map[highY][highX] == symb)) {
                highX++;
                highY++;
            }
            highX--;
            highY--;

            while (x - lowX < DOTS_TO_WIN && lowX >= 0 && y - lowY < DOTS_TO_WIN && lowY >= 0 && (map[lowY][lowX] == DOT_EMPTY || map[lowY][lowX] == symb)) {
                lowX--;
                lowY--;
            }
            lowX++;
            lowY++;

            for (int i = lowX, k = lowY; (i <= highX - DOTS_TO_WIN + 1) && (k <= highY - DOTS_TO_WIN + 1); i++, k++) {
                int numberSymb = 0, numberEmpty = 0;
                for (int j = i, l = k; (j < i + DOTS_TO_WIN) && (l < k + DOTS_TO_WIN); j++, l++) {
                    if (map[l][j] == symb) {
                        numberSymb++;
                        freedomWithFr++;
                    }
                    if (map[l][j] == DOT_EMPTY) numberEmpty++;
                }
                if (numberSymb > 0 || numberEmpty > 0) freedom++;
                if (numberSymb > step) step = numberSymb;
            }

            //2-я диагональ
            lowX = highX = x;
            lowY = highY = y;
            while (highX - x < DOTS_TO_WIN && highX < SIZE && y - highY < DOTS_TO_WIN && highY >= 0 && (map[highY][highX] == DOT_EMPTY || map[highY][highX] == symb)) {
                highX++;
                highY--;
            }
            highX--;
            highY++;

            while (x - lowX < DOTS_TO_WIN && lowX >= 0 && lowY - y < DOTS_TO_WIN && lowY < SIZE && (map[lowY][lowX] == DOT_EMPTY || map[lowY][lowX] == symb)) {
                lowX--;
                lowY++;
            }
            lowX++;
            lowY--;

            for (int i = lowX, k = lowY; (i <= highX - DOTS_TO_WIN + 1) && (k >= highY + DOTS_TO_WIN - 1); i++, k--) {
                int numberSymb = 0, numberEmpty = 0;
                for (int j = i, l = k; (j < i + DOTS_TO_WIN) && (l > k - DOTS_TO_WIN); j++, l--) {
                    if (map[l][j] == symb) {
                        numberSymb++;
                        freedomWithFr++;
                    }
                    if (map[l][j] == DOT_EMPTY) numberEmpty++;
                }
                if (numberSymb > 0 || numberEmpty > 0) freedom++;
                if (numberSymb > step) step = numberSymb;
            }


        }
        return step;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    // у противника выбирает элемент с максимальным количеством шагов до победы - stepXmax,
// при равных значениях stepXmax выбирает элемент с максимальным количеством проставленных фищек, входящих в победные комбинации - freedomWithFrXmax,
// при равных значениях freedomWithFrXmax выбирает элемент с максимальным количествоv победных комбинаций - freedomXmax
// у себя выбирает элемент с максимальным количеством шагов до победы - stepOmax,
// при равных значениях stepOmax выбирает элемент с максимальным количеством проставленных фищек, входящих в победные комбинации - freedomWithFrOmax,
// при равных значениях freedomWithFrOmax выбирает элемент с максимальным количествоv победных комбинаций - freedomOmax
// для хода, если  stepOmax >= stepXmax, выбирается лучший элемент для себя, иначе выбирается лучший элемент для противника
    public static void aiTurn() {
        int x, y;
        int stepX, stepO, stepXmax, stepOmax, xX = 0, yX = 0, xO = 0, yO = 0;
        int freedomXmax, freedomOmax, freedomWithFrXmax, freedomWithFrOmax;
        stepXmax = 0;
        freedomXmax = 0;
        stepOmax = 0;
        freedomOmax = 0;
        freedomWithFrXmax = 0;
        freedomWithFrOmax = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    stepX = calcStep(DOT_X, j, i);
                    if (stepX > stepXmax) {
                        stepXmax = stepX;
                        freedomXmax = freedom;
                        freedomWithFrXmax = freedomWithFr;
                        xX = j;
                        yX = i;
                    } else if (stepX == stepXmax && freedomWithFr > freedomWithFrXmax) {
                        freedomWithFrXmax = freedomWithFr;
                        freedomXmax = freedom;
                        xX = j;
                        yX = i;
                    } else if (stepX == stepXmax && freedomWithFr == freedomWithFrXmax && freedom > freedomXmax) {
                        freedomXmax = freedom;
                        xX = j;
                        yX = i;
                    }

                    stepO = calcStep(DOT_O, j, i);
                    if (stepO > stepOmax) {
                        stepOmax = stepO;
                        freedomOmax = freedom;
                        xO = j;
                        yO = i;
                    } else if (stepO == stepOmax && freedomWithFr > freedomWithFrOmax) {
                        freedomWithFrOmax = freedomWithFr;
                        freedomOmax = freedom;
                        xO = j;
                        yO = i;
                    } else if (stepO == stepOmax && freedomWithFr == freedomWithFrOmax && freedom > freedomOmax) {
                        freedomOmax = freedom;
                        xO = j;
                        yO = i;
                    }
                }
            }
        }
        if (stepOmax >= stepXmax) {
            x = xO;
            y = yO;
        } else {
            x = xX;
            y = yX;
        }

        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y +
                1));
        map[y][x] = DOT_O;
        lastXDOT_O = x;
        lastYDOT_O = y;
        printMap();
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
        lastXDOT_X = x;
        lastYDOT_X = y;
        printMap();
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        System.out.println("Введите размер поля:");
        SIZE = sc.nextInt();
        System.out.println("Введите, кто делает первый ход, Вы - 1, компьютер - 2:");
        firstMan1Comp2 = sc.nextInt();
        System.out.println("Ваши фишки: " + DOT_X);

        if (SIZE >= 3 && SIZE <= 5)
            DOTS_TO_WIN = 3;
        else if (SIZE >= 6 && SIZE <= 9)
            DOTS_TO_WIN = 4;
        else if (SIZE >= 10 && SIZE <= 30)
            DOTS_TO_WIN = 5;
        else {
            SIZE = 3;
            DOTS_TO_WIN = 3;
        }
        System.out.println("Выигрыш: " + DOTS_TO_WIN + " " + DOT_X);

        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
