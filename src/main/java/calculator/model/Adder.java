package calculator.model;

public class Adder {
    public static int addNum(int[] input) {
        int result = 0;
        
        for (int i : input) {
            result += i;
        }

        return result;
    }
}
