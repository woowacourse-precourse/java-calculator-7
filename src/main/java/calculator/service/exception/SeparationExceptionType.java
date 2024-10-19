package calculator.service.exception;

import calculator.exception.ExceptionType;

public enum SeparationExceptionType implements ExceptionType {

    NOT_EXIST_CUSTOM_SEPARATOR("커스텀 구분자가 존재하지 않습니다.")
    ;

    private final String message;

    SeparationExceptionType(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }
}
