package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.CalculatorImpl;
import calculator.model.ExtractNumber;
import calculator.util.MessageSource;
import calculator.validator.DelimiterValidator;
import calculator.validator.Validator;
import calculator.validator.ValueValidate;
import calculator.view.CalculatorView;
import calculator.view.CalculatorViewImpl;
import java.util.Locale;

public class AppConfig {

    private final Locale locale;

    public AppConfig(Locale locale) {
        this.locale = locale;
    }

    public CalculatorController calculatorController() {
        return new CalculatorController(calculator(), calculatorView());
    }

    public Calculator calculator() {
        return new CalculatorImpl(extractNumber(), messageSource());
    }

    public ExtractNumber extractNumber() {
        return new ExtractNumber(delimiterValidator(), valueValidator(), messageSource());
    }

    public Validator delimiterValidator() {
        return new DelimiterValidator(messageSource());
    }

    public Validator valueValidator() {
        return new ValueValidate(messageSource());
    }

    public CalculatorView calculatorView() {
        return new CalculatorViewImpl();
    }

    public MessageSource messageSource() {
        return new MessageSource(locale);
    }
}
