package calculator.view.constant.errorMessage;

import calculator.global.globalEnum.Message;

public enum InputErrorMessage implements Message {
    NULL_INPUT_ERROR("입력값은 0이 될 수 없습니다."),
    ;

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
