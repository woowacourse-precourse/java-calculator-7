package calculator.common;

import calculator.controller.StringCalculatorApplication;
import calculator.model.service.Calculator;
import calculator.model.implement.DelimiterChecker;
import calculator.model.implement.DelimiterExtractor;
import calculator.model.implement.DelimiterManager;
import calculator.model.implement.DelimiterStore;
import calculator.model.service.StringSumCalculator;
import calculator.model.implement.StringParser;
import calculator.view.ApplicationConsoleView;
import calculator.view.ApplicationView;
import calculator.view.input.InputConsoleView;
import calculator.view.output.OutputConsoleView;

public final class CalculatorAppConfig {

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
        return new StringParser(DelimiterStore.getInstance());
    }

    private DelimiterManager delimiterManager() {
        return new DelimiterManager(new DelimiterChecker(), new DelimiterExtractor(), DelimiterStore.getInstance());
    }
}
