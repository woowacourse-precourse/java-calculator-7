package calculator.enums;

public enum ErrorMessage {

    CAN_NOT_REGISTER_CUSTOM_SEPARATOR_BY_NUMBER("숫자는 커스텀 구분자로 등록 불가능합니다"),
    ONLY_CALC_DIGIT("숫자 이외의 값은 계산 불가능합니다"),
    EXCEED_MAX_NUM_LENGTH("18자리까지만 입력할 수 있습니다"),
    CAN_NOT_CALC_MINUS_NUMBER("음수는 계산 불가능합니다");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
