package calculator.common;

public enum ErrorMessage {
    NULL_INPUT("문자열이 입력되지 않았습니다."),
    NEGATIVE_NUMBER("음수는 허용되지 않습니다."),
    INVALID_NUMBER("숫자만 입력할 수 있습니다."),
    EMPTY_CUSTOM_DELIMITER("커스텀 구분자 사이 값이 비어있습니다."),
    MULTIPLE_CUSTOM_DELIMITERS("커스텀 구분자는 한번만 입력할 수 있습니다."),
    CONSECUTIVE_DELIMITERS("구분자가 연속해서 나타났습니다."),
    NUMBER_TOO_LARGE("숫자의 범위가 너무 큽니다."),
    MISSING_NUMBERS("숫자가 포함되지 않았습니다."),
    OUT_OF_RANGE_RESULT("결과가 범위를 초과합니다."),
    INVALID_FORMAT("// 뒤에는 반드시 \\n이 와야합니다."),
    INCORRECT_POSITION("//는 반드시 숫자 앞에 와야합니다.");
    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
