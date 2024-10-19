package calculator;

import java.util.List;

public class Calculator {

    private InputHandler inputHandler;

    public Calculator() {
        inputHandler = new InputHandler();
    }

    public void run() {
        List<Long> numbers = inputHandler.inputProcessor();
        long result = calculate(numbers);
        print(result);
    }

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

    public void print(long result) {
        System.out.println("결과 : " + result);
    }
}