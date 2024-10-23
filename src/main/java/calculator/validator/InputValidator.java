package calculator.validator;

import calculator.validator.strategies.ValidationStrategy;
import java.util.List;

// 여러 개의 검증 전략을 관리하고 실행하는 클래스
public class InputValidator {
    private final List<ValidationStrategy> validators;

    public InputValidator(List<ValidationStrategy> validators) {
        this.validators = validators;
    }

    public void validate(String input) {
        for (ValidationStrategy validator : validators) {
            validator.validate(input);
        }
    }
}
