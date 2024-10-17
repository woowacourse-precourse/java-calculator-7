package calculator;

import calculator.domain.Calculator;
import calculator.domain.Delimiters;
import calculator.domain.InputParser;
import calculator.domain.StringAddCalculator;
import calculator.ui.ViewManager;

public class Application {
    public static void main(String[] args) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator(
                new InputParser(new Delimiters()),
                new Calculator()
        );

        ViewManager viewManager = new ViewManager();

        String input = viewManager.userInput();

        int result = stringAddCalculator.splitAndSum(input);

        viewManager.output(result);
    }

}
