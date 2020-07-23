package example;

public class GuessNumber {
    private int[] answer;

    public GuessNumber(GenerateRandomNum generateRandomNum) {
        this.answer = generateRandomNum.generateRandomNum();
    }

    public String guess(int[] guessNum) {
        int A = 0;
        int B = 0;
        for (int num : answer) {
            for (int gNum : guessNum) {
                if (num == gNum) {
                    A++;
                }
            }
        }
        B = 4 - A;
        return String.format("%dA%dB", A, B);
    }

    public int[] generateRandom() {
        return new int[]{1, 2, 3, 4};
    }

    public boolean isValid(int[] answer) {
        return false;
    }
}
