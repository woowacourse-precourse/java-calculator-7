package calculator.constant;

public enum ErrorStatus {
    NO_NUMBER("계산기에서 처리 가능한 숫자 형식의 입력이 아닙니다."),
    NON_POSITIVE("숫자가 양수가 아닙니다."),
    INVALID_INPUT("커스텀 구분자가 잘못되었습니다."),
    NO_SEPARATOR("존재하지 않는 구분자입니다."),
    NO_INPUT("입력된 값이 존재하지 않습니다."),
    INVALID_COMMAND("잘못된 명령어입니다."),
    INVALID_RANGE("계산기의 성능을 초과했습니다.");
    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
