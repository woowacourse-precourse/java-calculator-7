package calculator.exception;

public class DelimiterException {
    private static final int VALID_LENGTH = 1;
    private static final int TYPE_ERROR_CUSTOM_DELIMITER = -1;

    public static void validateCustomDelimiter(String input) {
        if (input.length() != VALID_LENGTH || input.trim().isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자만 허용됩니다.");
        }

        if (Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }

    public static void validateCustomDelimiterFormat(int input) {
        if (input == TYPE_ERROR_CUSTOM_DELIMITER) {
            throw new IllegalArgumentException("올바른 형식의 커스텀 구분자가 아닙니다.");
        }
    }
}
