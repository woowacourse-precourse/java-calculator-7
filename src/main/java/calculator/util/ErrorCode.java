package calculator.util;

import calculator.model.Separator;

public enum ErrorCode {
    NUMBER_ERROR("숫자는 양수여야됩니다."),
    SEPARATOR_ERROR("구분자는 숫자일 수 없습니다.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
