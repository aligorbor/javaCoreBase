package ru.geekbrains.javaCoreAdvanced.homeWork.lesson1;

public interface Obstacle {
    default boolean start(Participant participant) {
        Sport sport = getSport();
        switch (sport.sportEnum) {
            case RUN: {
                participant.setSuccess(participant.run(sport));
                return participant.getSuccess();
            }
            case JUMP: {
                participant.setSuccess(participant.jump(sport));
                return participant.getSuccess();
            }
            default:
                return false;
        }
    }

    Sport getSport();

    void setSport(Sport sport);
}
