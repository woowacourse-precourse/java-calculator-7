package calculator;

import calculator.util.CalculatorUtil;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        CalculatorConfig calculatorConfig = new CalculatorConfig();
        CalculatorController calculator = new CalculatorController(calculatorConfig.calculatorService(), calculatorConfig.view());

        String input = calculator.executeInput();
        boolean isValid = CalculatorUtil.isValidInput(input);

        if (isValid) {
            List<String> delimiters = CalculatorUtil.extractDelimiter(input);
            List<Integer> numbers = CalculatorUtil.splitByDelimiters(delimiters, CalculatorUtil.formattingString(input));
            Integer result = calculator.executeCalculation(numbers);
            calculator.executeOutput(result);
        }
    }
}
