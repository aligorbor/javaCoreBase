package ru.geekbrains.javaCoreAdvanced.homeWork.lesson1;

public class Wall implements Obstacle {
    final private String name;
    private Sport jump = new Sport(SportEnum.JUMP, 0);

    public Wall(String name, int size) {
        this.name = name;
        jump.setMaxValue(size);
    }

    @Override
    public Sport getSport() {
        return jump;
    }

    @Override
    public void setSport(Sport sport) {
        jump = sport;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "name='" + name + '\'' +
                ", height=" + jump.getMaxValue() +
                '}';
    }
}
