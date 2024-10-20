package calculator.operations;

public class Calculator {

    private CalculatorStrategy calculatorStrategy;

    public Calculator(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }

    public long execute(long[] numbers) {
        return calculatorStrategy.calculate(numbers);
    }

}
