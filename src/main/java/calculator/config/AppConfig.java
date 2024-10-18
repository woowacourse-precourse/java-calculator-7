package calculator.config;

import calculator.service.CalculatorService;
import calculator.service.DelimiterService;
import calculator.validation.DelimiterNumberValidator;

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

}