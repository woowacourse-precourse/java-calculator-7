package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.CalculatorImpl;
import calculator.parser.DelimiterParser;
import calculator.validator.DelimiterValidator;
import calculator.validator.InputValidator;
import calculator.view.CalculatorView;
import calculator.view.CalculatorViewImpl;

public class AppConfig {

    public Calculator calculator() {
        return new CalculatorImpl(inputValidator(), delimiterParser());
    }

    public CalculatorView calculatorView() {
        return new CalculatorViewImpl();
    }

    public CalculatorController calculatorController() {
        return new CalculatorController(calculator(), calculatorView());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }

    private DelimiterValidator delimiterValidator() {
        return new DelimiterValidator();
    }

    private DelimiterParser delimiterParser() {
        return new DelimiterParser(delimiterValidator());
    }
}
