package calculator.constant;

public enum ErrorMessage {
    NUMBERS_MUST_POSITIVE("양수 값만 계산할 수 있어요."),
    NUMBERS_MUST_NUMBER("숫자만 계산할 수 있어요."),
    NUMBERS_RANGE("숫자는 1 ~ 9223372036854775807 사이의 값이어야 해요."),
    DELIMITER_MUST_LENGTH_1("구분자의 길이는 1 이어야 해요."),
    DELIMITER_MUST_CHARACTER("구분자는 문자만 지정할 수 있어요."),
    NUMBER_SEPARATOR_CUSTOM_DELIMITER_MUST_NOT_DEFAULT("커스텀 구분자는 기본 구분자외의 문자만 가능해요."),
    NUMBER_SEPARATOR_CUSTOM_DELIMITER_POSITION_FOREFRONT("커스텀 구분자는 맨 앞에만 올 수 있어요.");

    private static final String SPACE = " ";
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.join(SPACE, PREFIX, this.message);
    }
}