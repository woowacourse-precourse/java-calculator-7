package calculator.message;

public enum ErrorMessage implements Message {

    INVALID_BIG_INTEGER("숫자로 변환이 불가능한 문자입니다."),
    NOT_POSITVE_INTEGER("입력 값이 양수가 아닙니다."),
    INVALID_CUSTOM_DELIMITER_FORMAT("커스텀 구분자를 사용할 수 없는 형식입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return String.format("[ERROR : %s]", message);
    }

    @Override
    public String getFormatMessage(Object... args) {
        return String.format(getMessage(), args);
    }
}
