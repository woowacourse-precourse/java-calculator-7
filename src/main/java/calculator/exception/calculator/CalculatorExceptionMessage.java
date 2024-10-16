package calculator.exception.calculator;

public enum CalculatorExceptionMessage {

    MINUS_OR_ZERO_NUMBER("양수로 구성된 문자열 및 지정된 커스텀 구분자만 입력 가능 합니다."),
    WRONG_CUSTOM_DELIMITER_FORMAT("잘못된 커스텀 구분자 형식입니다.");

    final String message;

    CalculatorExceptionMessage(String message) {
        this.message = message;
    }
}
