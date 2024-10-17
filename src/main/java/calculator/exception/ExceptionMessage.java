package calculator.exception;

public enum ExceptionMessage {

    ERROR_MESSAGE("[ERROR] "),
    INPUT_IS_NOT_NUMBER_EXCEPTION("문자열은 구분자와 숫자만 입력되어야 합니다."),
    INPUT_IS_NOT_POSITIVE_EXCEPTION("문자열은 구분자와 양수만 입력되어야 합니다."),
    INPUT_IS_WRONG_EXCEPTION("기본 구분자(콜론 ':', 쉼표 ',') 또는 커스텀 구분자('//구분자\\n')를 사용해야 합니다."),
    CUSTOM_IS_WRONG_EXCEPTION("커스텀 구분자는 '//'와 '\\n'로 구성되어야 합니다.");

    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return ERROR_MESSAGE.exceptionMessage + exceptionMessage;
    }
}
