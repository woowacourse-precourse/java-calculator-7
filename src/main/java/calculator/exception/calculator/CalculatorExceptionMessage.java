package calculator.exception.calculator;

public enum CalculatorExceptionMessage {

    WRONG_INPUT("시스템에 없는 구분자를 사용하셨습니다."),
    MINUS_OR_ZERO_NUMBER("양수로 구성된 문자열만 입력 가능 합니다."),
    WRONG_CUSTOM_DELIMITER_FORMAT("잘못된 커스텀 구분자 형식입니다.");

    final String message;

    CalculatorExceptionMessage(String message) {
        this.message = message;
    }
}
