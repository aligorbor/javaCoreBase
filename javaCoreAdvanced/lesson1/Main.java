package ru.geekbrains.javaCoreAdvanced.homeWork.lesson1;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Мартин", 100, 1);
        Cat cat2 = new Cat("Барсик", 200, 2);
        Cat cat3 = new Cat("Шрек", 300, 3);
        Cat cat4 = new Cat("Бегемот", 400, 4);

        Man man1 = new Man("Вася", 10000, 3);
        Man man2 = new Man("Коля", 2000, 2);
        Man man3 = new Man("Петя", 3000, 4);
        Man man4 = new Man("Галя", 400, 1);

        Robot robot1 = new Robot("R2-D2", 10000, 10);
        Robot robot2 = new Robot("C-3PO", 400, 1);


        Treadmill treadmill1 = new Treadmill("Беговая дорожка 1", 100);
        Treadmill treadmill2 = new Treadmill("Беговая дорожка 2", 400);
        Treadmill treadmill3 = new Treadmill("Беговая дорожка 3", 1000);
        Treadmill treadmill4 = new Treadmill("Беговая дорожка 4", 10000);

        Wall wall1 = new Wall("Стена 1", 1);
        Wall wall2 = new Wall("Стена 2", 2);
        Wall wall3 = new Wall("Стена 3", 4);
        Wall wall4 = new Wall("Стена 4", 10);


        Participant[] participants = {cat1, cat2, cat3, cat4, man1, man2, man3, man4, robot1, robot2};
        Obstacle[] obstacles = {treadmill1, treadmill2, treadmill3, treadmill4, wall1, wall2, wall3, wall4};

        for (Obstacle obstacle : obstacles) {
            for (Participant participant : participants) {
                if (participant.getSuccess()) {
                    if (obstacle.start(participant))
                        System.out.println(participant + " преодолел " + obstacle);
                    else
                        System.out.println(participant + " не преодолел " + obstacle);
                }
            }
            System.out.println();
        }


    }
}
