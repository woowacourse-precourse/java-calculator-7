package calculator.formatter;

public enum DisplayFormat {

    INPUT_DISPLAY_FORMAT("덧셈할 문자열을 입력해 주세요."),
    OUTPUT_DISPLAY_FORMAT("결과 : %d");

    private final String format;

    DisplayFormat(String format) {
        this.format = format;
    }

    public String formatOutput(int result) {
        return String.format(this.format, result);
    }
}
