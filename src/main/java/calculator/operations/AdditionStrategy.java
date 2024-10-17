package calculator.operations;

public class AdditionStrategy implements CalculatorStrategy {

    @Override
    public int calculate(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
