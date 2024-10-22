package calculator.input.error;

public enum InputErrorType {

    NEED_POSITIVE_NUMBER("양수를 입력하세요."),
    CANT_FIND_CUSTOM_SEPARATOR("커스텀 구분자를 찾을 수 없습니다."),

    NEED_NUMBER_OR_SEPARATOR("양수와 구분자로 이루어진 문자열을 입력하세요.");

    final String message;

    InputErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
