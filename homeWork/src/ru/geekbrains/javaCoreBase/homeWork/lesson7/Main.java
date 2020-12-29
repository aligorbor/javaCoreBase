package ru.geekbrains.javaCoreBase.homeWork.lesson7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cat cat1 = new Cat("Мартин", 15);
        Cat cat2 = new Cat("Барсик", 8);
        Cat cat3 = new Cat("Шрек", 10);
        Cat cat4 = new Cat("Бегемот", 20);
        Cat cat5 = new Cat("Рыжик", 7);
        Cat cat6 = new Cat("Пупсик", 5);
        Cat cat7 = new Cat("Шмындрик", 11);
        Cat cat8 = new Cat("Котофей Иванович", 3);
        Cat[] cats = {cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8};
        for (Cat cat : cats) {
            System.out.println(cat);
        }
        Plate plate = new Plate(100);
        plate.info();
        boolean feed = true;
        boolean allCatsFull;
        while (feed) {
            allCatsFull = true;
            System.out.println("Добавить в миску еды? (у/n)");
            if (sc.next().equals("y")) {
                System.out.println("Введите целое число еды:");
                plate.setFood(sc.nextInt());
            } else {
                if (plate.getFood() == 0)
                    break;
            }
            ;
            System.out.println("Кормим котиков:");
            for (int i = 0; i < cats.length; i++) {
                cats[i].eat(plate);
                System.out.println(cats[i]);
                if (!cats[i].isSatiety())
                    allCatsFull = false;
            }
            plate.info();
            if (allCatsFull) {
                System.out.println("Все коты сытые. Поиграть с котиками? Они проголодаются. (у/n)");
                if (sc.next().equals("y")) {
                    for (int i = 0; i < cats.length; i++) {
                        cats[i].play();
                        System.out.println(cats[i]);
                    }
                } else
                    break;
            }
            System.out.println("Покормить котиков? (у/n)");
            feed = sc.next().equals("y");
        }
    }
}
