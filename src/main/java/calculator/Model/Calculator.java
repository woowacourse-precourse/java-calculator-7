package calculator.Model;

public class Calculator {
    private int sum = 0;

    public int calcSum(Input input) {
        int numberSize = input.size();
        for (int i=0; i<numberSize; i++) {
            sum += input.get(i);
        }

        return sum;
    }
}
