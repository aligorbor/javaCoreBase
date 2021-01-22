package ru.geekbrains.javaCoreAdvanced.homeWork.lesson1;

public interface Participant extends Runner, Jumper {
    boolean getSuccess();

    void setSuccess(boolean success);
}
