package calculator.vo;

public enum ExceptionMessage {
    INVALID_STRING("허용되지 않은 문자가 입력되었습니다."),
    INVALID_INPUT_NEGATIVE("음수는 허용되지 않습니다."),
    INVALID_DELIMITER("올바르지 않은 구분자입니다.");


    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public String getMessage(int parameter){
        return String.format(message, parameter);
    }
}
