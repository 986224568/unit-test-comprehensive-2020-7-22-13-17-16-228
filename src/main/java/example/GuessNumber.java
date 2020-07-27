package example;

import java.util.Arrays;
import java.util.HashSet;


public class GuessNumber {
    private int[] answer;
    private GenerateRandomNum generateRandomNum;

    public GuessNumber(GenerateRandomNum generateRandomNum) {
        this.answer = generateRandomNum.generateRandomNum();
    }

    public String guess(int[] guessNum) {
        int countOfCorrectNumber = 0;
        int countOfCorrectPosition = 0;

        for (int indexOfAnswer = 0; indexOfAnswer < 4; indexOfAnswer++) {
            int answerNumber = answer[indexOfAnswer];
            if (Arrays.stream(guessNum).anyMatch(i -> i == answerNumber)) {
                countOfCorrectPosition++;
            }
            if (answer[indexOfAnswer] == guessNum[indexOfAnswer]) {
                countOfCorrectNumber++;
            }
        }
        System.out.println(String.format("%dA%dB", countOfCorrectNumber, countOfCorrectPosition-countOfCorrectNumber));
        return String.format("%dA%dB", countOfCorrectNumber, countOfCorrectPosition-countOfCorrectNumber);


    }

    public void generateRandom() {
        this.generateRandomNum = new GenerateRandomNumBer();
        this.answer = generateRandomNum.generateRandomNum();
    }

    public boolean isValid(int[] answer) {
        if (answer == null || answer.length != 4) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : answer) {
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return true;
    }

    public GuessNumber() {
    }
}
