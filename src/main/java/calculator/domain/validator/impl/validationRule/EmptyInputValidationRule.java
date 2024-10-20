package calculator.domain.validator.impl.validationRule;

import calculator.domain.common.Message;
import calculator.domain.validator.impl.ValidationRule;

public class EmptyInputValidationRule implements ValidationRule {
    @Override
    public void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(Message.입력값이_비어있습니다);
        }
    }

    @Override
    public boolean canHandle(String input) {
        return true;
    }
}


