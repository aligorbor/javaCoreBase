package ru.geekbrains.javaCoreAdvanced.homeWork.lesson1;

public interface Runner {
    default boolean run(Sport run) {
        return run.getMaxValue() <= getSport(SportEnum.RUN).getMaxValue();
    }

    void setSport(Sport sport);

    Sport getSport(SportEnum sportEnum);
}
