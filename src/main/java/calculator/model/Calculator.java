package calculator.model;

public class Calculator {

    public int calculate(int[] numArray) {
        int result = 0;
        for (int i : numArray) {
            result += i;
        }
        return result;
    }
}
