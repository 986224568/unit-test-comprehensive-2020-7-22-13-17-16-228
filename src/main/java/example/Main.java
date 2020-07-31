package example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GenerateRandom generateRandomNum = new GenerateRandomNumber();
        GuessNumber guessNumber = new GuessNumber(generateRandomNum);
        int[] guessNum = null;
        int times = 6;
        while (times > 0){
            guessNum = inputGuessNum();
            guessNumGame(guessNum, guessNumber);
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

    private static void guessNumGame(int[] guessNum, GuessNumber guessNumber) {
        if(Validation.isValid(guessNum)){
            guessNumber.guess(guessNum);
        }else{
            System.out.println("Wrong Input，Input again");
        }
    }
}
