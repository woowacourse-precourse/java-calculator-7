package calculator;

import calculator.domain.calculator.Calculator;
import calculator.domain.delimiter.Delimiters;
import calculator.domain.input.InputParser;
import calculator.domain.calculator.StringAddCalculator;
import calculator.ui.ViewManager;

public class Application {
    public static void main(String[] args) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator(
                new InputParser(new Delimiters()),
                new Calculator()
        );

        ViewManager viewManager = new ViewManager();

        String input = viewManager.getInput();

        int result = stringAddCalculator.splitAndSum(input);

        viewManager.printOutput(result);
    }

}
