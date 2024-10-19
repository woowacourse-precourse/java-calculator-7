package calculator;

public enum CalculatorException {
    ONLY_CAN_USE_DIGIT("계산식의 처음과 마지막에는 숫자만 입력할 수 있습니다."),
    CANNOT_USE_MINUS("음수는 입력할 수 없습니다."),
    CANNOT_USE_THIS_SEPERATOR("등록되지 않은 구분자가 포함되어 있습니다."),
    ONLY_CAN_USE_ZERO_BETWEEN_SEPERATOR("0은 등록하고자 하는 구분자 사이에만 사용할 수 있습니다."),
    CANNOT_USE_DIGIT_IN_SEPERATOR("커스텀 구분자에 숫자를 입력할 수 없습니다.");
    private final String text;

    CalculatorException(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
