package calculator.exception.input;

public enum CalculatorExceptionMessage {

    WRONG_CUSTOM_DELIMITER_FORMAT("잘못된 커스텀 구분자 형식입니다.");

    final String message;

    CalculatorExceptionMessage(String message) {
        this.message = message;
    }
}
