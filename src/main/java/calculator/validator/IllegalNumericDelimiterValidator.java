package calculator.validator;

import java.util.List;

public class IllegalNumericDelimiterValidator {
    public static void validate(List<String> delimiters) {
        for (String delimiter : delimiters) {
            if (Character.isDigit(delimiter.charAt(0))) {
                throw new IllegalArgumentException("숫자는 커스텀 구분자로 입력되지 않습니다.");
            }
        }
    }
}
