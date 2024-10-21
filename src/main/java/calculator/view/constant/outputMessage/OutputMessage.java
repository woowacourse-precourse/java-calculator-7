package calculator.view.constant.outputMessage;

import calculator.global.globalEnum.Message;

public enum OutputMessage implements Message {
    START_MESSEAGE("덧셈할 문자열을 입력해 주세요."),
    RESULT_MESSAGE("결과 : "),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
