package calculator.application.validation;

import static calculator.infrastructure.exception.ErrorCode.*;

import calculator.application.Validator;

public class InputValidator implements Validator<String> {

    @Override
    public void validate(String target) {
        isTrimmed(target);
    }

    private void isTrimmed(String target) {
        if (!target.equals(target.trim())) {
            throw new IllegalArgumentException(INPUT_IS_NOT_TRIMMED.getMessage());
        }
    }
}
