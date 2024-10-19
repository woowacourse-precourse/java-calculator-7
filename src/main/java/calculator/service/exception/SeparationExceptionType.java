package calculator.service.exception;

import calculator.exception.ExceptionType;

public enum SeparationExceptionType implements ExceptionType {

    // SeparationService
    NO_INPUT("값을 입력하지 않았습니다."),
    // CustomSeparationService
    NOT_EXIST_CUSTOM_SEPARATOR("커스텀 구분자가 존재하지 않습니다."),
    STARTS_WITH_SEPARATOR("입력값이 구분자로 시작합니다."),
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
