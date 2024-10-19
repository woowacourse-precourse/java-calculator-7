package calculator.config;

import calculator.controller.StringAddCalculatorController;
import calculator.service.CalculatorService;
import calculator.service.DelimiterService;
import calculator.validator.DelimiterNumberValidator;
import calculator.validator.InputValidator;

public class AppConfig {

    private DelimiterService delimiterService() {
        return new DelimiterService();
    }

    private DelimiterNumberValidator delimiterNumberValidator() {
        return new DelimiterNumberValidator();
    }

    private CalculatorService calculatorService() {
        return new CalculatorService(delimiterService(), delimiterNumberValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }

    public StringAddCalculatorController stringAddCalculatorController() {
        return new StringAddCalculatorController(calculatorService(), inputValidator());
    }

}