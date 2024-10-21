package calculator.global.exception;

public enum Exception {
    CUSTOM_DELIMITER_FORMAT_ERROR("커스텀 구분자 포맷을 지켜주세요."),
    INVALID_DELIMITER_ERROR("구분자로 숫자는 사용할 수 없습니다."),
    NON_NUMERIC_INPUT_ERROR("입력된 값 중 숫자가 아닌 값이 있습니다."),
    POSITIVE_NUMBER_REQUIRED_ERROR("양수를 입력해주세요"),
    INPUT_REQUIRED_ERROR("입력을 부탁합니다.");

    private final String value;
    Exception(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
