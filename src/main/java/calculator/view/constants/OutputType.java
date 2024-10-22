package calculator.view.constants;

public enum OutputType {
    RESULT_TYPE("결과 : ");

    private final String message;

    OutputType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
