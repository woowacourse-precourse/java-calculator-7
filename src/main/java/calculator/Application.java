package calculator;

import calculator.common.CalculatorAppConfig;
import calculator.controller.CalculatorApplication;

public class Application {
    public static void main(String[] args) {
        CalculatorAppConfig calculatorAppConfig = CalculatorAppConfig.getInstance();
        CalculatorApplication calculatorApplication = calculatorAppConfig.stringCalculatorApplication();
        calculatorApplication.run();
    }
}
