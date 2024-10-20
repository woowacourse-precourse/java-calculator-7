package calculator.validation;

import java.util.List;

public class NumberValidator {
    private NumberValidator() {
    }

    public static void validateContainsOnlyPositiveDigits(List<String> tokens) {
        for(String token : tokens) {
            if(token.length() != 1) throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

}
