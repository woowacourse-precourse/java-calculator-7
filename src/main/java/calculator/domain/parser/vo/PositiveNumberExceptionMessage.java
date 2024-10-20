package calculator.domain.parser.vo;

public enum PositiveNumberExceptionMessage {

    NO_EMPTY("입력 리스트는 null이거나 비어있을 수 없습니다."),
    NO_NEGATIVE("음수는 허용되지 않습니다: ");

    private final String message;

    PositiveNumberExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
