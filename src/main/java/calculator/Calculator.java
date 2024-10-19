package calculator;

import java.util.List;

public class Calculator {

    private final InputHandler inputHandler;

    public Calculator() {
        inputHandler = new InputHandler();
    }

    public void run() {
        List<Long> numbers = inputHandler.inputProcessor();
        long result = calculate(numbers);
        print(result);
    }

    protected long calculate(List<Long> numbers) {
        long sum = 0;

        for (long number : numbers) {
            sum = Math.addExact(sum, number);
        }

        return sum;
    }

    protected void print(long result) {
        System.out.println("결과 : " + result);
    }
}