package calculator.common.exception;


public class InvalidDelimiterException extends IllegalArgumentException {
    private static final String INVALID_CUSTOM_DELIMITER_FORMAT = "잘못된 형식의 커스텀 구분자입니다.";
    private static final String INVALID_CUSTOM_DELIMITER = "커스텀 구분자는 한 문자여야 합니다.";
    private static final String DUPLICATE_DELIMITER = "기본 구분자와 중복되는 커스텀 구분자는 사용할 수 없습니다.";

    public InvalidDelimiterException(String message) {
        super(message);
    }

    public static InvalidDelimiterException invalidCustomDelimiterFormat() {
        return new InvalidDelimiterException(INVALID_CUSTOM_DELIMITER_FORMAT);
    }

    public static InvalidDelimiterException invalidCustomDelimiter() {
        return new InvalidDelimiterException(INVALID_CUSTOM_DELIMITER);
    }

    public static InvalidDelimiterException duplicateWithDefaultDelimiter() {
        return new InvalidDelimiterException(DUPLICATE_DELIMITER);
    }
}