package example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] guessNum = null;
        int times = 6;
        while (times > 0){
            guessNum = inputGuessNum();
            guessNumGame(guessNum);
            times--;
        }
    }

    private static int[] inputGuessNum() {
        int[] guessNum = new int[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            guessNum[i] = sc.nextInt();
        }
        return guessNum;
    }

    private static void guessNumGame(int[] guessNum) {
        GenerateRandomNum generateRandomNum = new GenerateRandomNumBer();
        GuessNumber guessNumber = new GuessNumber(generateRandomNum);
        if(guessNumber.isValid(guessNum)){
            guessNumber.guess(guessNum);
        }else{
            System.out.println("Wrong Input，Input again");
        }
    }
}
