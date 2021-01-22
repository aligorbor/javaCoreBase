package ru.geekbrains.javaCoreBase.homeWork.lesson6;

public class Cat extends Animal {
    protected static String className = "Кот";
    protected static double limitRun = 200;
    protected static double limitSwim = 0;
    protected static double limitJump = 2;
    protected String color;

    public Cat(String name) {
        this(name, className, limitRun, limitSwim, limitJump, "дворового кота");
    }

    public Cat(String name, String color) {
        this(name, className, limitRun, limitSwim, limitJump, color);
    }

    public Cat(String name, String className, double limitRun, double limitSwim, double limitJump, String color) {
        super(name, className, limitRun, limitSwim, limitJump);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", окрас " + color;
    }

}
