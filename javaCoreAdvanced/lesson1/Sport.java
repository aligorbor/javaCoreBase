package ru.geekbrains.javaCoreAdvanced.homeWork.lesson1;

public class Sport {
    SportEnum sportEnum;
    int MaxValue;

    public Sport(SportEnum sportEnum, int maxValue) {
        this.sportEnum = sportEnum;
        MaxValue = maxValue;
    }

    public int getMaxValue() {
        return MaxValue;
    }

    public void setMaxValue(int maxValue) {
        MaxValue = maxValue;
    }
}
