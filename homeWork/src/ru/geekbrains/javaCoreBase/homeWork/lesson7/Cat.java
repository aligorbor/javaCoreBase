package ru.geekbrains.javaCoreBase.homeWork.lesson7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety; //сытость

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public void eat(Plate p) {
        if(!satiety)
            satiety = p.decreaseFood(appetite);
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void play() {
            satiety = false;
    }

    @Override
    public String toString() {
        return "Кот '" + name + "' аппетит " + appetite + " " + (satiety?"сыт":"голоден");
    }
}
