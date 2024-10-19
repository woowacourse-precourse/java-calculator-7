package calculator.enums;

import java.text.MessageFormat;

public enum ErrorMessage {

    CUSTOM_DELIMITER_FORMAT_ERROR("커스텀 구분자를 사용하기 위한 형식이 잘못되었습니다."),
    TOKEN_FORMAT_ERROR("분리된 문자열에 숫자가 아닌 문자`{0}`가 포함되어 있습니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... params) {
        return MessageFormat.format(this.message, params);
    }
}
