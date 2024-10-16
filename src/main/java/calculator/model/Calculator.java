package calculator.model;

public class Calculator {

    private int total = 0;

    public int sum(int[] input) {
        for (int i : input) {
            total += i;
        }

        return total;
    }

    public int getTotal() {
        return total;
    }
}
