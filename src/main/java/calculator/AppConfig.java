package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.CalculatorImpl;
import calculator.model.ExtractNumber;
import calculator.validator.DelimiterValidator;
import calculator.validator.Validator;
import calculator.validator.ValueValidator;
import calculator.view.CalculatorView;
import calculator.view.CalculatorViewImpl;

public class AppConfig {

    public CalculatorController calculatorController() {
        return new CalculatorController(calculator(), calculatorView());
    }

    private Calculator calculator() {
        return new CalculatorImpl(extractNumberFormInput());
    }

    private ExtractNumber extractNumberFormInput() {
        return new ExtractNumber(delimiterValidator(), valueValidator());
    }

    private Validator delimiterValidator() {
        return new DelimiterValidator();
    }

    private Validator valueValidator() {
        return new ValueValidator();
    }

    private CalculatorView calculatorView() {
        return new CalculatorViewImpl();
    }
}
