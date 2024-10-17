package calculator.common;

import calculator.controller.StringCalculatorApplication;
import calculator.model.Calculator;
import calculator.model.DelimiterChecker;
import calculator.model.DelimiterExtractor;
import calculator.model.DelimiterManager;
import calculator.model.DelimiterStore;
import calculator.model.StringSumCalculator;
import calculator.model.StringParser;
import calculator.view.ApplicationConsoleView;
import calculator.view.ApplicationView;
import calculator.view.input.InputConsoleView;
import calculator.view.output.OutputConsoleView;

public class CalculatorAppConfig {

    private static final CalculatorAppConfig calculatorAppConfig = new CalculatorAppConfig();

    private CalculatorAppConfig() {

    }

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
        return new StringSumCalculator(delimiterManager(), stringParser());
    }

    private StringParser stringParser() {
        return new StringParser();
    }

    private DelimiterManager delimiterManager() {
        return new DelimiterManager(new DelimiterChecker(), new DelimiterExtractor(), DelimiterStore.getInstance());
    }
}
