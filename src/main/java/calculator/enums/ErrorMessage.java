package calculator.enums;

public enum ErrorMessage {
    BLANK_INPUT_NOT_ALLOWED("입력 문자열은 공백으로만 구성될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
