package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.CalculatorImpl;
import calculator.model.ExtractNumber;
import calculator.validator.DelimiterValidator;
import calculator.validator.Validator;
import calculator.validator.ValueValidate;
import calculator.view.CalculatorView;
import calculator.view.CalculatorViewImpl;

public class AppConfig {

    public CalculatorController calculatorController() {
        return new CalculatorController(calculator(), calculatorView());
    }

    public Calculator calculator() {
        return new CalculatorImpl(extractNumber());
    }

    public ExtractNumber extractNumber() {
        return new ExtractNumber(delimiterValidator(), valueValidator());
    }

    public Validator delimiterValidator() {
        return new DelimiterValidator();
    }

    public Validator valueValidator() {
        return new ValueValidate();
    }

    public CalculatorView calculatorView() {
        return new CalculatorViewImpl();
    }
}
