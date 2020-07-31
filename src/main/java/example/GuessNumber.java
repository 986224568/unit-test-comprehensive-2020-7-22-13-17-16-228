package example;

import java.util.Arrays;
import java.util.HashSet;


public class GuessNumber {
    private int[] answer;
    private GenerateRandom generateRandomNum;

    public GuessNumber(GenerateRandom generateRandomNum) {
        this.answer = generateRandomNum.generateRandomNum();
    }

    public String guess(int[] guessNum) {
        int countOfAllCorrect = 0;
        int countOfCorrectNum = 0;

        for (int indexOfAnswer = 0; indexOfAnswer < 4; indexOfAnswer++) {
            int answerNumber = answer[indexOfAnswer];
            if (Arrays.stream(guessNum).anyMatch(i -> i == answerNumber)) {
                countOfCorrectNum++;
            }
            if (answer[indexOfAnswer] == guessNum[indexOfAnswer]) {
                countOfAllCorrect++;
            }
        }
        System.out.println(String.format("%dA%dB", countOfAllCorrect, countOfCorrectNum-countOfAllCorrect));
        return String.format("%dA%dB", countOfAllCorrect, countOfCorrectNum-countOfAllCorrect);


    }

    public boolean isValid(int[] answerNums) {
        if (answerNums == null || answerNums.length != 4) {
            return false;
        }
        return !isContainsRepeat(answerNums);
    }

    public GuessNumber() {
    }

    private boolean isContainsRepeat(int[] answer) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : answer) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
