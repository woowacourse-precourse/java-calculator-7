package calculator.global.error;

public enum ErrorMessage {

    INPUT_IS_EMPTY("입력이 비어있습니다.", ErrorSeverity.WARNING),
    CUSTOM_DELIMITER_IS_NOT_DEFINED_PROPERLY("잘못된 형식입니다: 커스텀 구분자가 제대로 정의되지 않았습니다.", ErrorSeverity.CRITICAL),
    ALL_NUMBERS_ARE_EMPTY("모든 숫자가 비어있습니다.", ErrorSeverity.WARNING),
    AN_INVALID_NUMBER_WAS_ENTERED("유효하지 않은 숫자가 입력되었습니다.", ErrorSeverity.WARNING),
    NEGATIVE_NUMBERS_ARE_NOT_ALLOWED("음수는 허용되지 않습니다.", ErrorSeverity.CRITICAL);

    private final String message;
    private final ErrorSeverity severity;

    ErrorMessage(String message, ErrorSeverity severity) {
        this.message = message;
        this.severity = severity;
    }

    public String getMessage(){
        return message;
    }

    public ErrorSeverity getSeverity() {
        return severity;
    }

}
