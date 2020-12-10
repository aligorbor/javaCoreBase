package ru.geekbrains.javaCoreBase.homeWork.lesson6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cat cat1 = new Cat("Мартин", "рыжий");
        Cat cat2 = new Cat("Барсик", "серый");
        Cat cat3 = new Cat("Шрек", "белый");
        Cat cat4 = new Cat("Бегемот");

        Dog dog1 = new Dog("Гендальф", "ротвейлер");
        Dog dog2 = new Dog("Шериф", "боксер");
        Dog.limitRun = 400;
        Dog dog3 = new Dog("Пупс", "шпиц");
        Dog dog4 = new Dog("Дружок");

        dog2.setLimitRun(200);
        dog4.setLimitRun(600);
        cat4.setLimitJump(3);
        cat4.setLimitRun(1000);
        dog1.setLimitSwim(100);
        cat2.setLimitRun(100);

        Animal[] animals = {cat1, cat2, cat3, cat4, dog1, dog2, dog3, dog4};
        for (Animal animal : animals)
            System.out.println(animal);
        System.out.println("Введите дистанцию пробега: ");
        double distance = sc.nextDouble();
        for (Animal animal : animals)
            animal.run(distance);
        System.out.println("Введите высоту прыжка: ");
        distance = sc.nextDouble();
        for (Animal animal : animals)
            animal.jump(distance);
        System.out.println("Введите дистанцию заплыва: ");
        distance = sc.nextDouble();
        for (Animal animal : animals)
            animal.swim(distance);

    }

}
