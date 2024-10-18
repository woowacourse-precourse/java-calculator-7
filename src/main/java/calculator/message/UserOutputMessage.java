package calculator.message;

public enum UserOutputMessage implements MessageType {

    RESPONSE_MESSAGE("결과 : "),
    ;

    private final String message;

    UserOutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

