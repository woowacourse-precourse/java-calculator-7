package calculator.domain.validator.impl.validationRule;

import static calculator.domain.common.Message.입력값이_null입니다;

import calculator.domain.validator.impl.ValidationRule;

public class NullInputValidationRule implements ValidationRule {
    @Override
    public void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(입력값이_null입니다);
        }
    }

    @Override
    public boolean canHandle(String input) {
        return true;
    }
}