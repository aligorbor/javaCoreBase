package ru.geekbrains.javaCoreAdvanced.homeWork.lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String arr1[][] = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String arr2[][] = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String arr3[][] = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3"}, {"1", "2", "3", "4"}};
        String arr4[][] = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "qqq", "4"}, {"1", "2", "3", "4"}};

        try {
            System.out.println("Сумма элементов массива arr1 = " + sumArr4x4(arr1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива arr2 = " + sumArr4x4(arr2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива arr3 = " + sumArr4x4(arr3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива arr4 = " + sumArr4x4(arr4));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static int sumArr4x4(String arr[][]) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) throw new MyArraySizeException("Неверный размер массива: " + arr.length);
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException("Неверный размер массива: " + arr[i].length);
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка преобразования в int элемента с индексом: " + i + ", " + j);
                }

            }
        }
        return sum;
    }

}
