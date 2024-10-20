package calculator.validation;

import java.util.List;

public class NumberValidator {
    private NumberValidator() {
    }

    public static void validateContainsOnlyPositiveDigits(List<String> tokens) {
        for(String token : tokens) {
            if(token.length() == 0) continue;
            if(token.length() != 1) throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            if(token.charAt(0) - '0' <= 0) throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
    }

}
