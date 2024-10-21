package calculator;

public enum ErrorMessage {
    UNDEFINED_DELIMITER("정의되지 않은 구분자입니다."),
    UNRESOLVED_EXPRESSION("해석할 수 없는 식입니다.");

    private String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
