package calculator.infrastructure.exception;

public enum ErrorCode {
    INPUT_IS_NOT_TRIMMED("입력 문자열에 불필요한 공백이 포함되어 있습니다."),
    INPUT_IS_EMPTY("입력 문자열이 비어 있습니다."),
    INPUT_IS_NOT_ENDED_WITH_NUMBER("입력 문자열의 마지막 값이 숫자가 아닙니다."),
    INPUT_IS_NOT_PROPER_CUSTOM_DELIMITER("입력 문자열의 `//`와 `\n` 사이에 단어가 아닌 값이 주어졌습니다."),
    INPUT_CONTAINS_NEGATIVE_NUMBER("입력 문자열에 음수가 포함되어 있습니다."),
    INPUT_CONTAINS_DUPLICATED_DELIMITER("입력 문자열에 중복된 구분자가 포함되어 있습니다."),
    INVALID_DELIMITER("구분자가 비었거나 문자로 이루어지지 않았습니다."),
    INVALID_COLLECTION("컬렉션이 비었거나 컬렉션으로 변환할 수 없는 값이 주어졌습니다."),
    INVALID_NUMBER("숫자가 비었거나 숫자로 변환할 수 없는 값이 주어졌습니다."),;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
