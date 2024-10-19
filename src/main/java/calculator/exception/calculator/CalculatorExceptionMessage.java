package calculator.exception.calculator;

public enum CalculatorExceptionMessage {

    WRONG_INPUT("잘못된 값을 입력하셨습니다."),
    MINUS_OR_ZERO_NUMBER("양수로 구성된 문자열만 입력 가능 합니다.");

    final String message;

    CalculatorExceptionMessage(String message) {
        this.message = message;
    }
}
