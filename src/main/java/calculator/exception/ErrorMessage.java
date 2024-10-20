package calculator.exception;

public enum ErrorMessage {
    INVALID_TYPE("숫자 외의 값은 입력할 수 없습니다."),
    INVALID_FORMAL("잘못된 형식입니다."),
    INVALID_DELIMITER("허용되지 않은 구분자가 포함되어 있습니다."),
    INVALID_NUMBER("0과 음수는 입력할 수 없습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage(){
        return this.errorMessage;
    }
}