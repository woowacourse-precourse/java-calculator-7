package calculator;

import calculator.util.CalculatorUtil;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        View view = new View();
        CalculatorConfig calculatorConfig = new CalculatorConfig();
        CalculatorController calculator = new CalculatorController(calculatorConfig.calculatorService(), calculatorConfig.view());

        view.printMessage();
        String input = view.input();
        boolean isValid = CalculatorUtil.isValidInput(input);

        if (isValid) {
            List<String> delimiters = CalculatorUtil.extractDelimiter(input);
            List<Integer> numbers = CalculatorUtil.splitByDelimiters(delimiters, CalculatorUtil.formattingString(input));
            Integer result = calculator.executeCalculation(numbers);
            view.printResultMessage(result);
        }
    }
}
