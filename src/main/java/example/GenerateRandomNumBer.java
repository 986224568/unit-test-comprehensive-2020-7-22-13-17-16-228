package example;

import java.util.Random;

public class GenerateRandomNumBer implements GenerateRandomNum {
    @Override
    public int[] generateRandomNum() {
        String number = "";
        Random random = new Random();
        while (number.length() != 4) {
            String randomNum = random.nextInt(10) + "";
            if (number.indexOf(randomNum) == -1){
                number += randomNum;
            }
        }
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        return nums;
    }
}
