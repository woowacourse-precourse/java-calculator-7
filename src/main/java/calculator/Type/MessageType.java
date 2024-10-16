package calculator.Type;

public enum MessageType {


    MINUS_SEPERATOR("마이너스 구분자를 입력하셨습니다"),
    NUMBER_SEPERATOR("숫자를 구분자로 입력하셨습니다"),
    MANY_GROUP("구분자를 한 개 이상 입력했습니다"),
    INVALID_POSITION("구분자가 제일 앞에 있지 않습니다")
    ;
    String message;
    MessageType(String message) {
        this.message=message;
    }

    public String getMessage() {
        return this.message;
    }
}
