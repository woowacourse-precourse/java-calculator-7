package calculator.message;


public enum OutputMessage implements MessageProvider {

    RESPONSE_MESSAGE("결과 : ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

