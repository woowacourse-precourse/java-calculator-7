package calculator;

import calculator.endpoint.input.InputInterface;
import calculator.endpoint.output.DisplayInterface;
import calculator.service.Calculator;
import calculator.service.CalculatorFactory;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = CalculatorFactory.createCalculator();

        DisplayInterface.displaySystemMessage();
        String input = InputInterface.input();
        int result = calculator.calculate(input);
        DisplayInterface.displayAnswer(result);
    }
}
