package calculator.global.constant;

public enum OutputMessage {

    OUTPUT_PREFIX("결과 : ")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
