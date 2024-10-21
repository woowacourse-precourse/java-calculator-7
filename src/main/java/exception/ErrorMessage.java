package exception;

public enum ErrorMessage {
    LENGTH("입력된 숫자의 길이가 허용 범위를 초과하였습니다."),
    INVALID_TYPE("숫자 외의 값은 입력할 수 없습니다."),
    INVALID_NUMBER("0과 음수는 입력할 수 없습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage(){
        return this.errorMessage;
    }
}
