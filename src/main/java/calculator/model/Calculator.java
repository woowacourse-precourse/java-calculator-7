package calculator.model;

public class Calculator {

    public int sum(int[] input) {
        int total = 0;
        for (int i : input) {
            total += i;
        }

        return total;
    }
}
