package calculator;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorIO calculatorIO = new CalculatorIO();

        String inputString = calculatorIO.input();
        Map<String, String> splitString = calculator.split(inputString);

        calculator.getDivision(splitString.get("division"));
        if (!calculator.isValid(splitString.get("number"))) {
            throw new IllegalArgumentException();
        }
        calculator.getNumbers(splitString.get("number"));

        calculatorIO.output(calculator.calculateNumber());
    }
}
