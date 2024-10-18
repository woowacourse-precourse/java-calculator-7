package calculator;

public enum ErrorMessage {

    NOT_FOUND_CUSTOM_DELIMITER("커스텀 구분자가 입력되지 않았습니다."),
    OUT_OF_RANGE_CUSTOM_DELIMITER("커스텀 구분자가 2글자 이상입니다.");

    private String message;

    ErrorMessage(String s) {
    }

    public String getMessage() {
        return message;
    }
}
