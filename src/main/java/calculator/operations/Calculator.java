package calculator.operations;

public class Calculator {

    private CalculatorStrategy calculatorStrategy;

    public Calculator(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }

    public int execute(int[] numbers) {
        return calculatorStrategy.calculate(numbers);
    }

}
