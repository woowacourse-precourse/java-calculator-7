package calculator.back.exception.message;

public enum ExceptionMessage {
    INVALID_INPUT_EXCEPTION(
            "입력 형식에 적합하지 않거나 구분자가 존재하지 않습니다.\n" + "다음과 같은 형식으로 입력해야합니다.\n" + "Regex: ^(//<Custom Delimiter>\\n)*"
                    + "([1-9]\\d*)*([<Delimiters>][1-9]\\d*)*$");

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    private final String exceptionMessage;

    public String getMessage() {
        return this.exceptionMessage;
    }
}
