package ru.geekbrains.javaCoreAdvanced.homeWork.lesson1;

public class Man implements Participant {
    final private String name;
    private Sport run = new Sport(SportEnum.RUN, 0);
    private Sport jump = new Sport(SportEnum.JUMP, 0);
    private boolean success;

    public Man(String name, int maxRun, int maxJump) {
        this.name = name;
        run.setMaxValue(maxRun);
        jump.setMaxValue(maxJump);
        success = true;
    }

    @Override
    public boolean getSuccess() {
        return success;
    }

    @Override
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public void setSport(Sport sport) {
        switch (sport.sportEnum) {
            case RUN:
                run.setMaxValue(sport.getMaxValue());
                break;
            case JUMP:
                jump.setMaxValue(sport.getMaxValue());
        }
    }

    @Override
    public Sport getSport(SportEnum sportEnum) {
        switch (sportEnum) {
            case JUMP:
                return jump;
            case RUN:
                return run;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", run=" + run.getMaxValue() +
                ", jump=" + jump.getMaxValue() +
                '}';
    }
}
