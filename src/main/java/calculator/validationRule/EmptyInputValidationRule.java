package calculator.validationRule;

import static calculator.util.Message.입력값이_비어있습니다;

public class EmptyInputValidationRule implements ValidationRule {
    @Override
    public void validate(String input) {
        if (input == "") {
            throw new IllegalArgumentException(입력값이_비어있습니다);
        }
    }
}


