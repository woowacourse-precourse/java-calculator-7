package calculator;

public enum ErrorSubstance {
    NEGATIVE_NUM_AVAILABLE("음수는 입력할 수 없습니다"),
    INVALID_STRING("입력하신 숫자에 잘못된 문자가 포함되어 있습니다");

    private final String message;

    ErrorSubstance(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
