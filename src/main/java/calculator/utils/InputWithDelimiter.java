package calculator.utils;

public class InputWithDelimiter {
    private final String input;
    private final CalculatorDelimiter calculatorDelimiter;

    public InputWithDelimiter(String input, CalculatorDelimiter calculatorDelimiter) {
        this.input = input;
        this.calculatorDelimiter = calculatorDelimiter;
    }

    public String getInput() {
        return input;
    }

    public CalculatorDelimiter getCalculatorDelimiter() {
        return calculatorDelimiter;
    }
}
