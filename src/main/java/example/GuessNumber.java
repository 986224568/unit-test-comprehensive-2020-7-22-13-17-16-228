package example;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class GuessNumber {
    private int[] answer;

    public GuessNumber(GenerateRandomNum generateRandomNum) {
        this.answer = generateRandomNum.generateRandomNum();
    }

    public String guess(int[] guessNum) {
        int countOfCorrectNumber = 0;
        int countOfCorrectPosition = 0;

        for (int indexOfAnswer = 0; indexOfAnswer < 4; indexOfAnswer++) {
            int answerNumber = answer[indexOfAnswer];
            if (Arrays.stream(guessNum).anyMatch(i -> i==answerNumber)) {
                countOfCorrectPosition++;
            }
            if (answer[indexOfAnswer] == guessNum[indexOfAnswer]) {
                countOfCorrectNumber++;
            }
        }

        return String.format("%dA%dB", countOfCorrectNumber, countOfCorrectPosition-countOfCorrectNumber);


    }

    public void generateRandom() {
        String charList = "0123456789";
        StringBuilder generateNum = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < charList.length(); i++) {
            generateNum.append(charList.charAt(Math.abs(random.nextInt()) % charList.length()));
        }
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.valueOf(generateNum.charAt(i));
        }
        this.answer = nums;
//        this.answer = new int[]{1,2,3,4};
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
