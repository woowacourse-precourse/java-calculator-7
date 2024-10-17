package calculator.common;

import calculator.controller.StringCalculatorApplication;
import calculator.model.calculator.Calculator;
import calculator.model.calculator.StringCalculator;
import calculator.view.ApplicationConsoleView;
import calculator.view.ApplicationView;
import calculator.view.input.InputConsoleView;
import calculator.view.output.OutputConsoleView;

public class CalculatorAppConfig {

    private static final CalculatorAppConfig calculatorAppConfig = new CalculatorAppConfig();

    public static CalculatorAppConfig getInstance() {
        return calculatorAppConfig;
    }

    public StringCalculatorApplication stringCalculatorApplication() {
        return new StringCalculatorApplication(applicationView(), calculator());
    }

    private ApplicationView applicationView() {
        return new ApplicationConsoleView(new InputConsoleView(), new OutputConsoleView());
    }

    private Calculator calculator() {
        return new StringCalculator();
    }
}
