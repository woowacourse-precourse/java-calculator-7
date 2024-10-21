package calculator.exception;

import calculator.constants.SeparatorConstants;

public enum Exception {
    INVALID_NUMBER_FORMAT("정수 형식이어야 합니다 : "),
    INVALID_NEGATIVE_NUMBER("양수만 허용됩니다 : "),
    INVALID_NUMBER_SIZE("입력된 숫자가 너무 큽니다 : "),

    INVALID_CUSTOM_SEPARATOR_FORMAT(
            "커스텀 구분자는 " + SeparatorConstants.CUSTOM_SEPARATOR_PREFIX + "와 "
                    + SeparatorConstants.CUSTOM_SEPARATOR_SUFFIX + "사이에 위치해야합니다."),
    INVALID_NUMBER_SEPARATOR("커스텀 구분자는 숫자가 될 수 없습니다 : "),
    INVALID_SEPARATOR_LENGTH("커스텀 구분자는 "
            + SeparatorConstants.MAX_CUSTOM_SEPARATOR_LENGTH + "자를 넘을 수 없습니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
