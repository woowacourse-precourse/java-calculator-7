package calculator.exception;

import calculator.exception.basic.BasicErrorCode;
import calculator.exception.basic.CausedBy;

public enum CalculatorErrorCode implements BasicErrorCode {

    NEGATIVE_NUMBER("음수는 허용되지 않습니다."),
    START_WITH_SEPARATOR_OR_SOMETHING("입력 문자열은 반드시 숫자 혹은 공백으로 시작해야 합니다."),
    END_WITH_SEPARATOR_OR_SOMETHING("입력 문자열은 반드시 숫자 혹은 공백 끝나야 합니다."),
    INVALID_EXPRESSION("허용되지 않은 구분자 포함 및 잘못된 식 입니다.");

    private final String message;

    CalculatorErrorCode(String message) {
        this.message = message;
    }

    @Override
    public CausedBy causedBy() {
        return CausedBy.of(name(), message);
    }

    @Override
    public String getExplainError() {
        return message;
    }
}
