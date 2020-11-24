package ru.geekbrains.javaCoreBase.lesson1;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hello, World!!!");
        //byte, short, int, long, float, double, char, boolean
        System.out.println("Возможные значения byte от " + Byte.MIN_VALUE + " до " + Byte.MAX_VALUE);
        System.out.println("Возможные значения short от " + Short.MIN_VALUE + " до " + Short.MAX_VALUE);
        System.out.println("Возможные значения int от " + Integer.MIN_VALUE + " до " + Integer.MAX_VALUE);
        System.out.println("Возможные значения long от " + Long.MIN_VALUE + " до " + Long.MAX_VALUE);
        System.out.println("Возможные значения float от " + Float.MIN_VALUE + " до " + Float.MAX_VALUE);
        System.out.println("Возможные значения double от " + Double.MIN_VALUE + " до " + Double.MAX_VALUE);
        System.out.println("Возможные значения char от " + (int)Character.MIN_VALUE + " до " + (int)Character.MAX_VALUE);
        System.out.println("Возможные значения boolean от " + false + " до " + true);

        byte b = 127;
        short s = 32767;
        int i = 2147483647;
        long l = 9223372036854775807L;
        float f = 3.4028235E38f;
        double d = 1.7976931348623157E308;
        char ch = '\uffff';
        boolean bl = true;

        System.out.println("Например: " );
        System.out.println("byte b = " + ++b);
        System.out.println("short s = " + ++s);
        System.out.println("int i = " + ++i);
        System.out.println("long l = " + ++l);
        System.out.println("float f = " + f);
        System.out.println("double d = " + d);
        System.out.println("char ch = " + ch);
        System.out.println("boolean bl = " + bl);

        System.out.println("Задание 3: a * (b + (c / d)) = " + calculate(1,2,3,4));

        System.out.println("Задание 4: task10and20 = " + task10and20 (8, 10));

        System.out.println("Задание 5:");
        isPositiveOrNegative(-5);

        System.out.println("Задание 6:");
            if (isNegative(5))
                System.out.println("Передано отрицательное число");
            else
                System.out.println("Передано положительное число");

        System.out.println("Задание 7:");
        greetings("Игорь");

        System.out.println("Задание 8:");
        for (i=1900;i<=2100;i++){
            leapYear(i);
        }

    }
//    3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
//    где a, b, c, d – входные параметры этого метода;
    public static double calculate(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }
//  4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
//  от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    public static boolean task10and20 (int a, int b){
        int c = a + b;
        return 10 <= c && c <= 20;
        }

//  5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
//  в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом
    public static void isPositiveOrNegative (int x){
        String str;
        if (x>=0) str = "положительное"; else str = "отрицательное";
        System.out.println("Передано " + str + " число " + x);
        }

//  6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true,
//  если число отрицательное;
    public static boolean isNegative (int x){
        return x<0;
    }
//  7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен
//  вывести в консоль сообщение «Привет, указанное_имя!»;
    public static void greetings(String name) {
         System.out.println("Привет, " + name + "!");
    }
//  Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
//  Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void leapYear(int year) {
        boolean leap;
        if (year% 4 == 0 && (year% 100 != 0 || year% 400 == 0))
            System.out.println("Год " + year + " высокосный");
        else
            System.out.println("Год " + year + " не высокосный");
    }
}
