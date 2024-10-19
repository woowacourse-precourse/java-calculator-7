package calculator.config;

import calculator.controller.StringAddCalculatorController;
import calculator.service.StringAddCalculatorService;

public class AppConfig {
    private AppConfig() {
    }

    public static StringAddCalculatorController config() {
        return new StringAddCalculatorController(stringAddCalculatorService());
    }

    private static StringAddCalculatorService stringAddCalculatorService() {
        return new StringAddCalculatorService();
    }
}
