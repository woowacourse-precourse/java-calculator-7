package calculator.validation;

public enum MessageType {


    MINUS_SEPERATOR("마이너스 구분자를 입력하셨습니다"),
    NUMBER_SEPERATOR("숫자를 구분자로 입력하셨습니다"),
    INVALID_SEPERATOR("커스텀 구분자가 아닌 기호를 입력했습니다"),
    NEGATIVE_INPUT("음수를 입력했습니다")
    ;

    String message;
    MessageType(String message) {
        this.message=message;
    }

    public String getMessage() {
        return this.message;
    }
}
