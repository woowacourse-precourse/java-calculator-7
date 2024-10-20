package calculator.domain.validator.impl.validationRule;

import static calculator.domain.common.Message.잘못된_기본_입력_형식입니다;

import calculator.domain.validator.impl.ValidationRule;

public class BasicFormatValidationRule implements ValidationRule {

    @Override
    public void validate(String input) {
        if (!canHandle(input)) {
            throw new IllegalArgumentException(잘못된_기본_입력_형식입니다);
        }
    }

    @Override
    public boolean canHandle(String input) {
        return input.matches("^\\d+([,:]\\d+)*$") || input.matches("^//.\n\\d+([,:]\\d+)*$");
    }
}
