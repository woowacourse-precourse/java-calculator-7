package calculator.domain.constant.errorMessage;

import calculator.global.globalEnum.Message;

public enum ValueError implements Message {
    MINUS_VALUE("음수가 올 수 없습니다."),
    INVALID_VALUE_FORMAT("올바르지 않은 형식입니다."),
    OUT_OF_RANGE_VALUE("Int 범위 외로는 입력할 수 없습니다."),
    OUT_OF_RANGE_RESULT("결과가 범위를 초과합니다.");


    private final String message;

    ValueError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
