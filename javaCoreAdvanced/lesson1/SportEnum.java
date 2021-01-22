package ru.geekbrains.javaCoreAdvanced.homeWork.lesson1;

public enum SportEnum {
    RUN("бег", 0), JUMP("прыжки", 0);
    private String russianTitle;

    public String getRussianTitle() {
        return russianTitle;
    }

    SportEnum(String russianTitle, int maxValue) {
        this.russianTitle = russianTitle;
    }

}
