package ru.geekbrains.javaCoreAdvanced.homeWork.lesson1;

public class Treadmill implements Obstacle {
    final private String name;
    private Sport run = new Sport(SportEnum.RUN, 0);

    public Treadmill(String name, int size) {
        this.name = name;
        run.setMaxValue(size);
    }

    @Override
    public Sport getSport() {
        return run;
    }

    @Override
    public void setSport(Sport sport) {
        run = sport;
    }

    @Override
    public String toString() {
        return "Treadmill{" +
                "name='" + name + '\'' +
                ", length=" + run.getMaxValue() +
                '}';
    }
}
