package calculator.view;

public enum ViewMessage {
    RESULT("결과 : ");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
