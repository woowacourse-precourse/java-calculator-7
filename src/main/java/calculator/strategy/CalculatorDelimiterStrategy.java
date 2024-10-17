package calculator.strategy;

public interface CalculatorDelimiterStrategy {
    Integer execute(String expression);

    Integer[] splitNumbers(String expression);
}
