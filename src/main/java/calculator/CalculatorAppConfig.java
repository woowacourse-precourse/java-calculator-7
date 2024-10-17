package calculator;

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
