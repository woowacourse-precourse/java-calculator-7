package calculator.validationRule;

import static calculator.util.Message.잘못된_기본_입력_형식입니다;

public class BasicFormatValidationRule implements ValidationRule {

    @Override
    public void validate(String input) {
        if (!input.matches("^\\d+([,:]\\d+)*$")) {
            throw new IllegalArgumentException(잘못된_기본_입력_형식입니다);
        }
    }

    @Override
    public boolean canHandle(String input) {
        return true;
    }

}
