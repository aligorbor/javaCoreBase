package ru.geekbrains.javaCoreAdvanced.homeWork.lesson5;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        calcSimply();
        calc2Threads();
    }

    public static void calcSimply() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++)
            arr[i] = 1;
        long a = System.currentTimeMillis();
        calc(arr, 0);
        System.out.println("Время расчета calcSimply: " + (System.currentTimeMillis() - a));
        calcSum(arr);
    }

    public static void calc2Threads() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++)
            arr[i] = 1;

        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread t1 = new Thread(() -> {
            calc(a1, 0);
        }, "A1");
        Thread t2 = new Thread(() -> {
            calc(a2, h);
        }, "A2");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Время расчета calc2Threads: " + (System.currentTimeMillis() - a));
        calcSum(arr);
    }

    public static void calc(float[] arr, int shift) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            j = i + shift;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
    }

    public static void calcSum(float[] arr) {
        double sum = 0;
        for (float v : arr) sum = sum + v;
        System.out.printf("Cумма значений всех элементов массива после расчета: %f%n", sum);
    }

}
