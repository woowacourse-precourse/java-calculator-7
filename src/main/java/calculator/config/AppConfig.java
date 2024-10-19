package calculator.config;

import calculator.controller.StringAddCalculatorController;
import calculator.service.CalculatorService;
import calculator.service.DelimiterService;
import calculator.validation.DelimiterNumberValidator;
import calculator.validation.InputValidator;

public class AppConfig {

    public DelimiterService delimiterService() {
        return new DelimiterService();
    }

    public DelimiterNumberValidator delimiterNumberValidator() {
        return new DelimiterNumberValidator();
    }

    public CalculatorService calculatorService() {
        return new CalculatorService(delimiterService(), delimiterNumberValidator());
    }

    public InputValidator inputValidator() {
        return new InputValidator();
    }

    public StringAddCalculatorController stringAddCalculatorController() {
        return new StringAddCalculatorController(calculatorService(), inputValidator());
    }

}