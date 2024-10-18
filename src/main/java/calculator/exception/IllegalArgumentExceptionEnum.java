package calculator.exception;

public enum IllegalArgumentExceptionEnum {
    MULTIPLE_DELIMITERS("Delimiter는 하나 뿐이어야 합니다."),
    INVALID_LENGTH("Delimiter의 길이는 1이어야 합니다."),
    DIGIT_NOT_ALLOWED("Delimiter는 숫자가 될 수 없습니다."),

    INVALID_CHARACTER("허용되지 않은 문자가 포함되어 있습니다."),
    EMPTY_TOKEN("토큰의 길이가 0입니다."),
    OUT_OF_RANGE("토큰의 크기가 표현 범위를 넘었습니다."),

    ADDITION_OVERFLOW("덧셈 결과가 표현 범위를 넘었습니다."),
    ;


    private final String message;

    IllegalArgumentExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
