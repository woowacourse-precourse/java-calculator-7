package calculator.common.exception;

public enum ExceptionType {
    NEGATIVE_NUMBER("음수는 입력할 수 없습니다.", IllegalArgumentException.class),
    NOT_DELIMITER("구분자가 아닌 값이 포함되어 있습니다.", IllegalArgumentException.class),
    CUSTOM_DELIMITER_FORMAT_WRONG("커스텀 구분자의 형식이 올바르지 않습니다.", IllegalArgumentException.class),
    CUSTOM_DELIMITER_EMPTY("커스텀 구분자가 비어있습니다.", IllegalArgumentException.class),
    CUSTOM_DELIMITER_CONTAINS_NUMBER("커스텀 구분자에 숫자가 포함되어 있습니다.", IllegalArgumentException.class),
    CUSTOM_DELIMITER_CONTAINS_ESCAPE("커스텀 구분자에 이스케이프 문자가 포함되어 있습니다.", IllegalArgumentException.class),
    PARSE_INTEGER_FAILED("정수로 변환할 수 없는 값이 포함되어 있습니다.", IllegalArgumentException.class),

    UNSUPPORTED_NUMBER_CLASS("지원하지 않는 숫자 클래스입니다.", UnsupportedOperationException.class);

    private final String message;
    private final Class<? extends RuntimeException> exceptionClass;

    ExceptionType(String message, Class<? extends RuntimeException> exceptionClass) {
        this.message = message;
        this.exceptionClass = exceptionClass;
    }

    public String getMessage() {
        return message;
    }

    public Class<? extends RuntimeException> getExceptionClass() {
        return exceptionClass;
    }
}
