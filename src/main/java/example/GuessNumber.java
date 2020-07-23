package example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class GuessNumber {
    private int[] answer;

    public GuessNumber(GenerateRandomNum generateRandomNum) {
        this.answer = generateRandomNum.generateRandomNum();
    }

    public String guess(int[] guessNum) {
        int A = 0;
        int B = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            if (answer[i] == guessNum[i]) {
                A++;
            }
            set.add(guessNum[i]);
        }
        for (int num : answer) {
            if (set.contains(num)) {
                B++;
            }
        }
        B = B - A;
        return String.format("%dA%dB", A, B);


    }

    public void generateRandom() {
        String charList = "0123456789";
        StringBuilder generateNum = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<charList.length();i++) {
            generateNum .append(charList.charAt(Math.abs(random.nextInt())%charList.length()));
        }
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.valueOf(generateNum.charAt(i));
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
