package calculator.domain.errorMessage;

import calculator.global.globalEnum.Message;

public enum parseError implements Message {
    INVALID_FORMAT("올바르지 않은 포맷입니다."),
    ;

    private final String message;

    parseError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
