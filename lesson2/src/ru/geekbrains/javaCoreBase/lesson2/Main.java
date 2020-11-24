package ru.geekbrains.javaCoreBase.lesson2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]");
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        arr01(arr1);
        for (int i = 0; i < arr1.length; i++)
            System.out.print(arr1[i]+" ");
        System.out.println();
        System.out.println();

        System.out.println("Задание 2: [ 0 3 6 9 12 15 18 21 ]");
        final int ARRSIZE = 8;
        int[] arr2 = new int[ARRSIZE];;
        intarr(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println();

        System.out.println("Задание 3: [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};;
        arr6x2(arr3);
        System.out.println(Arrays.toString(arr3));
        System.out.println();

        System.out.println("Задание 4: ");
        int[][] arr4 = new int[ARRSIZE][ARRSIZE];
        arrdiag1(arr4);
        System.out.println();

        System.out.println("Задание 5: ");
        int[] arr5 = {4, 1, 0, 7, 23, 14, 3, 8, 89, 2};
        arrMinMax(arr5);
        System.out.println();

        System.out.println("Задание 6: ");
        int[] arr6t1 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] arr6t2 = {1, 1, 1, 2, 1};
        int[] arr6f = {1, 1, 1, 3, 1};
        printBalance(arr6t1);
        printBalance(arr6t2);
        printBalance(arr6f);
        System.out.println();

        System.out.println("Задание 7: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]");
        int[] arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int n = 7;
        arrshift(arr7,n);
        System.out.println("n = " + n + " " + Arrays.toString(arr7));
        n = -7;
        arrshift(arr7,n);
        System.out.println("n = " + n + " " + Arrays.toString(arr7));
        System.out.println();

        System.out.println("Задание 8: Напечатать массив спиралью");
        //int[] arr8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        int[] arr8 = new int[100];
        for (int i = 0; i < 100; i++) arr8[i] = i + 1;
        int dim = 10;
        arrspiral(arr8,dim);

    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void arr01(int[] arr){
        for (int i = 0; i < arr.length; i++)
            arr[i] = (arr[i] == 0)?1:0;
    }

    //2. Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

    public static void intarr(int[] arr){
        for (int i = 0; i < arr.length; i++){
          switch (i){
              case 0:
                  arr[i] = 0;
                  break;
              case 1:
                  arr[i] = 3;
                  break;
              case 2:
                  arr[i] = 6;
                  break;
              case 3:
                  arr[i] = 9;
                  break;
              case 4:
                  arr[i] = 12;
                  break;
              case 5:
                  arr[i] = 15;
                  break;
              case 6:
                  arr[i] = 18;
                  break;
              case 7:
                  arr[i] = 21;
          }
        }
    }

   //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void arr6x2(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void arrdiag1(int[][] arr){
        if (arr.length == arr[0].length) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (i == j || j == arr[i].length - 1 - i) arr[i][j] = 1;
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        } else System.out.println("Массив не квадратный");
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void arrMinMax(int[] arr){
        int minindex = 0;
        int maxindex = 0;
        for (int i = 1; i < arr.length; i++){
           if (arr[i] < arr[minindex]) minindex = i;
           if (arr[i] > arr[maxindex]) maxindex = i;
        }
        System.out.println("Массив: " + Arrays.toString(arr));
        System.out.println("Минимальный элемент " + arr[minindex] + " с индексом " + minindex);
        System.out.println("Максимальный элемент " + arr[maxindex] + " с индексом " + maxindex);
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
    // части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int[] arr){
        int sumarr = Arrays.stream(arr).sum();
        int sumleft = 0;
        for (int i = 0; i < arr.length - 1; i++){
            sumleft += arr[i];
            if (sumleft == sumarr - sumleft) return true;
        }
        return false;
    }

    public static void printBalance(int[] arr) {
        String s = " не";
        if (checkBalance(arr)) s = "";
        System.out.println("Массив " + Arrays.toString(arr) + s + " сбалансирован");
    }

//7. **** Написать метод, которому на вход подается одномерный массив и число n
// (может быть положительным, или отрицательным), при этом метод должен сместить
// все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    public static void arrshift(int[] arr, int n){
        int arrtmp =0;
        int nmod = (n>=0)?n:-n;
        for (int i = 1; i <= nmod; i++)
            if (n > 0) {
                arrtmp = arr[0];
                for (int j = 1; j < arr.length; j++) arr[j - 1] = arr[j];
                arr[arr.length-1] = arrtmp;
            } else{
                arrtmp = arr[arr.length-1];
                for (int j = arr.length-2; j >= 0; j--) arr[j + 1] = arr[j];
                arr[0] = arrtmp;
            }
        }
//Напечатать массив спиралью
    public static void arrspiral(int[] arr, int sqdim){
        int[][] sq = new int[sqdim][sqdim];
        fillsquare(arr, 0, sq, 0, sqdim-1);
        for (int i = 0; i < sqdim; i++) {
            for (int j = 0; j < sqdim; j++) {
                //System.out.print("  " + sq[i][j]);
                System.out.format("% 5d",sq[i][j]);
            }
            System.out.println();
        }
    }

    public static void fillsquare(int[] arr, int arrfrom, int[][] sq, int sqfrom, int sqind) {
       if(arrfrom < arr.length && sqind >= 0) {
            int arrfromnew = arr.length;
            for (int i = arrfrom; i < arr.length; i++) {
                if (i - arrfrom <= sqind) {
                    sq[sqfrom + i - arrfrom][sqfrom] = arr[i];
                } else if (i - arrfrom > sqind && i - arrfrom <= 2 * sqind) {
                    sq[sqind + sqfrom][sqfrom + i - arrfrom - sqind] = arr[i];
                } else if (i - arrfrom > 2 * sqind && i - arrfrom <= 3 * sqind) {
                    sq[sqind+ sqfrom - i + arrfrom + 2*sqind][sqind + sqfrom] = arr[i];
                } else if (i - arrfrom > 3 * sqind && i - arrfrom < 4 * sqind) {
                    sq[sqfrom][sqfrom - i + arrfrom + 4*sqind] = arr[i];
                    arrfromnew = i + 1;
                }
            }
           fillsquare(arr, arrfromnew, sq, sqfrom+1, sqind-2);
       }
    }
}
