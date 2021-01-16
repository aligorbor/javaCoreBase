package ru.geekbrains.javaCoreBase.homeWork.lesson6;

public class Dog extends Animal {
    protected static String className = "Собака";
    protected static double limitRun = 500;
    protected static double limitSwim = 10;
    protected static double limitJump = 0.5;
    protected String breed;

    public Dog(String name) {
        this(name, className, limitRun, limitSwim, limitJump, "дворянская");
    }

    public Dog(String name, String breed) {
        this(name, className, limitRun, limitSwim, limitJump, breed);
    }

    public Dog(String name, String className, double limitRun, double limitSwim, double limitJump, String breed) {
        super(name, className, limitRun, limitSwim, limitJump);
        this.breed = breed;
    }

    @Override
    public String toString() {
        return super.toString() + ", порода " + breed;
    }
}
