package calculator.infrastructure.constants;

public enum ResponseFormat {
    CALCULATION_RESULT("결과 : %s");

    private final String format;

    ResponseFormat(String format) {
        this.format = format;
    }

    public String applyFormat(String result) {
        return String.format(format, result);
    }
}
