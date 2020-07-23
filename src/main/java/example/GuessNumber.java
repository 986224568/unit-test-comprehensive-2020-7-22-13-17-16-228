package example;

import java.util.HashSet;

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

    public int[] generateRandom() {
        return new int[]{1, 2, 3, 4};
    }

    public boolean isValid(int[] answer) {
        return false;
    }
}
