package example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class GenerateRandomNumber implements GenerateRandom {
    @Override
    public Integer[] generateRandomNum() {
        List<Integer> numList = new ArrayList<>();
        int range = 10;
        int randomNum;
        Random random = new Random();
        while (numList.size() != 4) {
            randomNum = random.nextInt(range);
            if (!numList.contains(randomNum)) {
                numList.add(randomNum);
            }
        }
        Integer[] returnNums = new Integer[numList.size()];
        numList.toArray(returnNums);
        return returnNums;

        //String strings[]=(String [])list.toArray();
    }

}
