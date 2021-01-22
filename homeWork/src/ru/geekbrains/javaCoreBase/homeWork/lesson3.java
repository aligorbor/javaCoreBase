package ru.geekbrains.javaCoreBase.homeWork;

import java.util.Scanner;

public class lesson3 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Задание 1");
        int range = 9;
        int attempt = 3;
        playGuessNum(range, attempt);

        System.out.println("Задание 2");
        String[] words = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        playGuessWord(words);
        scanner.close();
    }

    public static void playGuessNum(int range, int attempt) {
        boolean playElse = false;
        do {
            if (guessNum(range, attempt))
                System.out.println("Вы угадали!");
            else
                System.out.println("Вы не угадали!");
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            playElse = scanner.nextInt() > 0;
        } while (playElse);
    }

    private static boolean guessNum(int range, int attempt) {
        int number = (int) (Math.random() * range);
        int i = attempt;
        boolean boolGuess = false;
        while (i > 0) {
            System.out.println("Угадайте число от 0 до " + range);
            int inputNumber = scanner.nextInt();
            if (inputNumber == number) {
                boolGuess = true;
                break;
            } else if (inputNumber > number)
                System.out.println("Загаданное число меньше");
            else
                System.out.println("Загаданное число больше");
            i--;
        }
        return boolGuess;
    }

    public static void playGuessWord(String[] words) {
        String word = words[(int) (Math.random() * (words.length - 1))];
        String inputWord = "";
        boolean playElse = false;
        do {
           // System.out.println(word);
            System.out.println("Угадайте слово ");
            inputWord = scanner.next();
        } while (!showChars(word, inputWord));
        System.out.println("Вы угадали!");
    }

    private static boolean showChars(String word, String inputWord) {
        StringBuilder str = new StringBuilder();
        boolean boolGuess = false;
        if (inputWord.equals(word))
            boolGuess = true;
        else {
            for (int i = 0; i < 15; i++) {
                if (i <= word.length() - 1) {
                    if (inputWord.charAt(i) == word.charAt(i))
                        str.append(word.charAt(i));
                    else
                        str.append("#");
                } else
                    str.append("#");
            }
        }
        System.out.println(str);
        return boolGuess;
    }
}
