package calculator.util;

public enum ErrorMessage {
    INPUT_DATA_WITH_DEFAULT_DELIMITER_FORMAT(
            "[F0001]",
            "기본 구분자를 사용하는 경우 숫자와 기본 구분자만 입력 가능합니다."),
    CUSTOM_DELIMITER_FORMAT(
            "[F0002]",
            "대시(-), 역슬래시(\\), 슬래시(/)는 커스텀 구분자로 사용할 수 없습니다."),
    ARITHMETIC_WITH_CUSTOM_DELIMITER_FORMAT(
            "[F0003]",
            "커스텀 구분자는 정해진 //와 \\n 사이에 정의되어야 합니다."),
    CUSTOM_DELIMITER_LIMIT(
            "[R0001]",
            "커스텀 구분자는 최대 3개까지 등록 가능합니다."),
    ARITHMETIC_LENGTH_LIMIT(
            "[R0002]",
            "연산할 숫자는 최대 30개까지 입력 가능합니다."),
    ARITHMETIC_RANGE_LIMIT(
            "[R0003]",
            "연산할 숫자의 범위는 0부터 1000까지만 등록 가능합니다.");

    String errorCode;
    String errorMessage;

    ErrorMessage(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getError() {
        return Message.ERROR_TAG.getSentence() + errorCode + " " + errorMessage;
    }
}