package exception;


public enum ErrorMessage {
    INVALID_TYPE("사용자 입력이 잘못되었습니다."),

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage(){
        return this.errorMessage;
    }
}
