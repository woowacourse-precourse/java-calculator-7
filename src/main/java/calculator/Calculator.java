package calculator;

import calculator.input.InputHandler;

import java.util.List;

public class Calculator implements CalculatorImpl{

    private InputHandler inputHandler;

    public Calculator() {
        inputHandler = new InputHandler();
    }

    @Override
    public void run() {
        List<Long> numbers = inputHandler.inputProcessor();
    }

    @Override
    public int calculate(List<Long> numbers) {
        return 0;
    }

    @Override
    public void print(long result) {
    }
}