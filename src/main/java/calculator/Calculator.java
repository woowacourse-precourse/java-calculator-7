package calculator;

import calculator.input.InputHandler;
import calculator.input.InputHandlerImpl;
import java.util.List;

public class Calculator implements CalculatorImpl {

    private InputHandlerImpl inputHandler;

    public Calculator() {
        inputHandler = new InputHandler();
    }

    @Override
    public void run() {
        List<Long> numbers = inputHandler.inputProcessor();
        long result = calculate(numbers);
        print(result);
    }

    @Override
    public long calculate(List<Long> numbers) {
        long sum = 0;

        try {
            for (long number : numbers) {
                sum += number;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return sum;
    }

    @Override
    public void print(long result) {
        System.out.println("결과 : " + result);
    }
}