package calculator.exception;

public enum CalculatorException {

    DELIMITER_NOT_FOUND("구분자가 존재하지 않습니다."),

    OPERAND_NOT_FOUND("피연산자가 존재하지 않습니다."),
    OPERAND_NOT_ZERO("피연산자는 0이 될 수 없습니다.)"),
    OPERAND_NOT_NEGATIVE("피연산자는 음수가 될 수 없습니다."),
    OPERAND_OVERFLOW("피연산자가 가능한 연산 범위를 초과하였습니다."),

    CUSTOM_DELIMITER_NOT_BLANK("구분자는 공백이 될 수 없습니다."),
    CUSTOM_DELIMITER_NOT_ALLOWED("구분자로 허용되지 않은 문자입니다."),
    CUSTOM_DELIMITER_NOT_NUMBER("구분자는 숫자가 될 수 없습니다."),

    OPERAND_NOT_STRING("피연산자에 구분자 이외의 문자가 포함될 수 없습니다."),

    RESULT_OVERFLOW("연산 결과가 표현 가능한 범위를 초과하였습니다.");

    private final String errorMessage;

    CalculatorException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
