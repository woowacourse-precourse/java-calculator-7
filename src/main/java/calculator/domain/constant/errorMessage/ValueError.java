package calculator.domain.constant.errorMessage;

import calculator.global.globalEnum.Message;

public enum ValueError implements Message {
    MINUS_VALUE("음수가 올 수 없습니다."),
    INVALID_VALUE_FORMAT("올바르지 않은 형식입니다.");

    private final String message;

    ValueError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
