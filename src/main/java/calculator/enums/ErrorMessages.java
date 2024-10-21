package calculator.enums;

public enum ErrorMessages {
    EMPTY_INPUT("입력이 이루어지지 않았습니다."),
    INVALID_CUSTOM_DELIMITER_FORMAT("커스텀 구분자 형식(//커스텀구분자\\n)을 준수해주세요."),
    NUMBER_DELIMITER("숫자는 커스텀 구분자로 지정할 수 없습니다."),
    INVALID_DELIMITER_FORMAT_END("양수,구분자,양수의 입력 형식을 지켜주세요. 현재 구분자로 끝나고 있습니다."),
    INVALID_DELIMITER_FORMAT_START("양수,구분자,양수의 입력 형식을 지켜주세요. 현재 구분자로 시작하고 있습니다."),
    EMPTY_NUMBER_INPUT("양수입력이 비어있습니다."),
    INVALID_NUMBER_INPUT("올바르지 않은 양수 입력입니다: ");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
