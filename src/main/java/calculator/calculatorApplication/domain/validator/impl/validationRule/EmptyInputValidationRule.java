package calculator.calculatorApplication.domain.validator.impl.validationRule;

import calculator.calculatorApplication.domain.validator.impl.ValidationRule;

public class EmptyInputValidationRule implements ValidationRule {
    @Override
    public void validate(String input) {

    }

    @Override
    public boolean canHandle(String input) {
        return true;
    }
}


