package calculator.message;

public enum ErrorMessage {
    구분자입력에러메시지("구분자 입력 방식이 잘못되었습니다. 다시 입력해주세요."),
    숫자입력에러메시지("숫자(양수인 정수)만 입력해주세요."),
    음수입력에러메시지("음수는 입력되면 안됩니다. 다시 입력해주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
