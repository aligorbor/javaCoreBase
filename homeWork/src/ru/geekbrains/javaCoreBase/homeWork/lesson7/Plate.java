package ru.geekbrains.javaCoreBase.homeWork.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        } else
            return false;
    }

    public void setFood(int food) {
        if (this.food + food >= 0)
            this.food += food;
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("В миске еды: " + food);
    }
}
