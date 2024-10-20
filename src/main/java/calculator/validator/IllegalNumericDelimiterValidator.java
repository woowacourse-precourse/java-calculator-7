package calculator.validator;

public class IllegalNumericDelimiterValidator {
    public static void validate(String customDelimiterString) {
        for (char delimiter : customDelimiterString.toCharArray()) {
            if (Character.isDigit(delimiter)) {
                throw new IllegalArgumentException("숫자는 커스텀 구분자로 입력되지 않습니다.");
            }
        }
    }
}
