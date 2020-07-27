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
        System.out.println(String.format("%dA%dB", countOfCorrectNumber, countOfCorrectPosition-countOfCorrectNumber));
        return String.format("%dA%dB", countOfCorrectNumber, countOfCorrectPosition-countOfCorrectNumber);


    }

    public void generateRandom() {
        String number = "";
        Random rd = new Random();
        while (number.length() != 4) {
            String rn = rd.nextInt(10) + "";
            if (number.length()==1){
                if ("0".equals(rn)){
                    continue;
                }
            }
            if (number.indexOf(rn) == -1){
                number += rn;
            }
        }
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        this.answer = nums;
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
