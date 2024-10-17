package calculator.validationRule;

import static calculator.util.Message.입력값이_null입니다;

public class NullInputValidationRule implements ValidationRule {
    @Override
    public void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(입력값이_null입니다);
        }
    }
}