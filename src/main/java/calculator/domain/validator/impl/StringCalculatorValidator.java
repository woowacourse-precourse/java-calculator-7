package calculator.domain.validator.impl;

import calculator.domain.calculation.InputValidator;
import calculator.domain.validator.impl.validationRule.CompositeValidationRule;

public class StringCalculatorValidator implements InputValidator {
    private final CompositeValidationRule compositeValidationRule;

    public StringCalculatorValidator(CompositeValidationRule compositeValidationRule) {
        this.compositeValidationRule = compositeValidationRule;
    }

    @Override
    public void validate(String input) {
        compositeValidationRule.validate(input);
    }
}