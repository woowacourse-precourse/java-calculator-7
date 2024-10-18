package calculator.validator;

import calculator.validationRule.CompositeValidationRule;

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