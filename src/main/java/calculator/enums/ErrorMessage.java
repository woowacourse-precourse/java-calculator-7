package calculator.enums;

public enum ErrorMessage {
    BLANK_INPUT_NOT_ALLOWED("입력 문자열은 공백으로만 구성될 수 없습니다."),
    FIRST_CHAR_CANNOT_BE_SPACE("입력 문자열의 첫 문자는 공백일 수 없습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
