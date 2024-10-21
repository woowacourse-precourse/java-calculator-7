package calculator.validation;

public class InputFormatValidator {
    private static final String ERROR_NEGATIVE_NUMBER = "음수는 허용되지 않습니다.";
    private static final String ERROR_STARTS_WITH_CHAR = "커스텀 문자 지정 외에는 문자로 시작할 수 없습니다.";

    public static void validateFormat(String input) throws IllegalArgumentException {
        if (input.startsWith("-")) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
        }

        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException(ERROR_STARTS_WITH_CHAR);
        }
    }
}
