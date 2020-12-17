package sample;

import java.util.Random;

public class GuessNum {
    private final int range;
    private final int attempt;
    private int attemptCount;
    private int guessNumber;
    private final Random random = new Random();

    public GuessNum() {
        range = 11;
        attempt = 3;
        newGame();
    }

    public GuessNum(int range, int attempt) {
        this.range = range;
        this.attempt = attempt;
        newGame();
    }

    public void newGame() {
        guessNumber = random.nextInt(range);
        attemptCount = 0;
    }

    public String play(int userNumber) {
        attemptCount++;
        if (userNumber == guessNumber) {
            newGame();
            return "Вы угадали! Играем снова!";
        } else if (attemptCount == attempt) {
            newGame();
            return "Вы не угадали, играем снова!";
        } else if (userNumber > guessNumber)
            return "Загаданное число меньше";
        else
            return "Загаданное число больше";
    }

}
