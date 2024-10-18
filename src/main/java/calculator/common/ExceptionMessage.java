package calculator.common;

public enum ExceptionMessage {
    INPUT_IS_NULL("계산할 문자를 입력해주세요"),
    CUSTOM_DELIMITER_FORMAT_NOT_MATCH("커스텀 구분자 포맷을 지켜주세요"),
    CALCULATE_PART_IS_INVALID("구분자와 숫자로만 입력해주세요."),
    NUMBER_NOT_POSITIVE("양수만 입력해주세요."),
    CUSTOM_DELIMITER_NOT_INCLUDE_NUMBER("커스텀 구분자는 숫자를 포함할 수 없습니다.");

    private final String value;

    ExceptionMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
