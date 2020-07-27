package example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GenerateRandomNum generateRandomNum = new GenerateRandomNumBer();
        GuessNumber guessNumber = new GuessNumber(generateRandomNum);
        Scanner sc = new Scanner(System.in);
        int[] guessNum = new int[4];
        int times = 6;
        while (times > 0){
            for (int i = 0; i < 4; i++) {
                guessNum[i] = sc.nextInt();
            }
            if(guessNumber.isValid(guessNum)){
                guessNumber.guess(guessNum);
            }else{
                System.out.println("Wrong Input，Input again");
            }
            times--;
        }
    }
}
