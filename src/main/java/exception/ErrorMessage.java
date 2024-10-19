package exception;

public enum ErrorMessage {

    ERROR_INPUT_IS_NUMBER("[ERROR] 구분자 외 입력은 오직 숫자만 가능합니다."),
    ERROR_INPUT_IS_POSITIVE("[ERROR] 숫자는 양수만 입력 가능합니다."),
    ERROR_INPUT_IS_EMPTY("[ERROR] 구분자 사이에 값을 입력해야 합니다."),
    ERROR_INPUT_GET_DELIMITER("[ERROR] 커스텀 구분자를 지정하기 위해선 //로 열고 \\n으로 닫아줘야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
