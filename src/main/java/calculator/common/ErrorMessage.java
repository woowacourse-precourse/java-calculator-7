package calculator.common;

public class ErrorMessage {
    public static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "음수는 허용되지 않습니다: ";
    public static final String INVALID_NUMBER_FORMAT_ERROR_MESSAGE = "잘못된 숫자 형식입니다: ";
    public static final String INVALID_CUSTOM_DELIMITER_FORMAT_ERROR_MESSAGE = "잘못된 형식입니다. 커스텀 구분자는 //과 \\n 사이에 있어야 합니다.";
    public static final String CUSTOM_DELIMITER_CANNOT_BE_NUMBER_ERROR_MESSAGE = "커스텀 구분자는 숫자이면 안됩니다.";

    private ErrorMessage() {
    }
}
