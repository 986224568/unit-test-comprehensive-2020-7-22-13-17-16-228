package example;

import java.util.HashSet;

public class Validation {
    public static boolean isValid(int[] answerNums) {
        if (answerNums == null || answerNums.length != 4) {
            return false;
        }
        return !isContainsRepeat(answerNums);
    }

    public static boolean isContainsRepeat(int[] answer) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : answer) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
