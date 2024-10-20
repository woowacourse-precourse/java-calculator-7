package exception;

public enum ExceptionMessage {
    INVALID_CUSTOM_SEPARATOR_CONTAINS_NUMBER("커스텀 구분자에는 숫자가 올 수 없습니다."),
    INVALID_CUSTOM_SEPARATOR_FORMAT("커스텀 구분자 생성 형식을 확인해주세요."),
    INVALID_CUSTOM_SEPARATOR_CONTAINS_BACKSPACE("커스텀 구분자에는 백스페이스(\\)가 올 수 없습니다."),
    CUSTOM_SEPARATOR_NOT_FOUND("커스텀 구분자를 찾을 수 없습니다."),
    ONLY_NUMBERS_ALLOWED_EXCEPT_SEPARATOR("구분자를 포함한 입력값을 다시 확인해주세요."),
    ONLY_POSITIVE_NUMBERS("숫자는 양수만 입력할 수 있습니다.");

    private final String exceptionMessage;


    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getMessage(){
        return exceptionMessage;
    }
}
