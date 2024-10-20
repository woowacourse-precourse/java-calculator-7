package calculator.enums;

public enum ErrorText {
    CUSTOM_DELIMITER_FROMAT("커스텀 구분자는 //문자\\n 형식이어야 합니다."),
    CUSTOM_DELIMITER_POSITION("커스텀 구분자는 앞에 위치해야 합니다."),
    POSITIVE_NUMBERS_ONLY("양수만 입력할 수 있습니다."),
    NUMBERS_AND_DELIMITERS_ONLY("숫자와 구분자만 입력할 수 있습니다.");

    private final String errorText;

    ErrorText(String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return errorText;
    }
}
