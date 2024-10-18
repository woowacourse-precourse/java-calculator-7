package calculator.domain.message;

public enum ErrorMessage implements MessageProvider {

    MISSING_INPUT("입력이 비어 있습니다."),
    POSITIVE_INPUT_REQUIRED("양수를 입력해주세요"),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
