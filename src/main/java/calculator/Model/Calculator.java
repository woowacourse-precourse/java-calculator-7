package calculator.Model;

public class Calculator {
    static int sum = 0;

    public int calcSum(Input input) {
        int numberSize = input.size();
        for (int i=0; i<numberSize; i++) {
            sum += input.get(i);
        }
        return sum;
    }
}
