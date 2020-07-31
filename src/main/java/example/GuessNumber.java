package example;

import java.util.Arrays;
import java.util.HashSet;


public class GuessNumber {
    private Integer[] answer;
    private GenerateRandom generateRandomNum;

    public GuessNumber(GenerateRandom generateRandomNum) {
        this.answer = generateRandomNum.generateRandomNum();
    }

    public String guess(int[] guessNum) {
        int countOfAllCorrect = findCountOfAllCorrect(guessNum);
        int countOfCorrectNum = findCountOfCorrectNum(guessNum);
        return String.format("%dA%dB", countOfAllCorrect, countOfCorrectNum-countOfAllCorrect);
    }

    private int findCountOfCorrectNum(int[] guessNum) {
        int countOfCorrectNum = 0;
        for (int indexOfAnswer = 0; indexOfAnswer < 4; indexOfAnswer++) {
            int answerNumber = answer[indexOfAnswer];
            if (Arrays.stream(guessNum).anyMatch(i -> i == answerNumber)) {
                countOfCorrectNum++;
            }
        }
        return countOfCorrectNum;
    }

    private int findCountOfAllCorrect(int[] guessNum) {
        int countOfAllCorrect = 0;
        for (int indexOfAnswer = 0; indexOfAnswer < 4; indexOfAnswer++) {
            if (answer[indexOfAnswer] == guessNum[indexOfAnswer]) {
                countOfAllCorrect++;
            }
        }
        return countOfAllCorrect;
    }

    public GuessNumber() {
    }

}
