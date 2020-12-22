package ru.geekbrains.javaCoreAdvanced.homeWork.lesson1;

public interface Jumper {
    default boolean jump(Sport jump) {
        return jump.getMaxValue() <= getSport(SportEnum.JUMP).getMaxValue();
    }

    void setSport(Sport sport);

    Sport getSport(SportEnum sportEnum);
}
