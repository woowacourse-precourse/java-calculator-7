package calculator.domain.constant.errorMessage;

import calculator.global.globalEnum.Message;

public enum ParseError implements Message {
    INVALID_FORMAT("//뒤에는 반드시 \\n이 와야합니다."),
    INCORRECT_POSITION("//는 반드시 숫자앞에 와야합니다.");

    private final String message;

    ParseError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
