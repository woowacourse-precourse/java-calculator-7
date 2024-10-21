package calculator;

import java.util.Arrays;

public class AddCalculator {
    private final String[] stringArr;
    private int sum;

    public AddCalculator(String[] strArr) {
        this.stringArr = strArr;
    }
    public int add() {
        int[] toIntArr = convertStringToInt();
        for (int i : toIntArr) {
            sum += i;
        }
        return sum;
    }

    private int[] convertStringToInt() {
        return Arrays.stream(stringArr).mapToInt(Integer::parseInt).toArray();
    }
}
