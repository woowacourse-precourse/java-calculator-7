package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.CalculatorImpl;
import calculator.model.ExtractNumber;
import calculator.validator.CustomDelimiterValueValidator;
import calculator.validator.DefalutDelimiterValueValidator;
import calculator.validator.DelimiterValidator;
import calculator.validator.Validator;
import calculator.view.CalculatorView;
import calculator.view.CalculatorViewImpl;

public class AppConfig {

    public CalculatorController calculatorController() {
        return new CalculatorController(calculator(), calculatorView());
    }

    private Calculator calculator() {
        return new CalculatorImpl(extractNumber());
    }

    private ExtractNumber extractNumber() {
        return new ExtractNumber(delimiterValidator(), customDelimiterValueValidator(),
                defalutDelimiterValueValidator());
    }

    private Validator delimiterValidator() {
        return new DelimiterValidator();
    }

    private Validator customDelimiterValueValidator() {
        return new CustomDelimiterValueValidator();
    }

    private Validator defalutDelimiterValueValidator() {
        return new DefalutDelimiterValueValidator();
    }

    private CalculatorView calculatorView() {
        return new CalculatorViewImpl();
    }
}
