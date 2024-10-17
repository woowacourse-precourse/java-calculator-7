package calculator;

import calculator.delimiter.DelimiterPattern;
import java.util.List;

public class InputValidator {
    private static final String validateErrorMessage = "문자열 입력 유효성 검사에 실패하였습니다.";

    private final List<DelimiterPattern> patterns;

    public InputValidator(List<DelimiterPattern> patterns) {
        this.patterns = patterns;
    }

    public void validate(String input) {
        boolean isValid = patterns.stream()
                .anyMatch(pattern -> pattern.validate(input));
        if (!isValid) {
            throw new IllegalArgumentException(validateErrorMessage);
        }
    }
}
