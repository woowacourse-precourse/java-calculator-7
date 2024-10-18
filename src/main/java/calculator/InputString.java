package calculator;

public class InputString {
    private final String value;

    public InputString(String input) {
        this.value = input;
    }

    public CustomDelimiter extractCustomDelimiter() {
        if (value.startsWith("//") && value.contains("\\n")) { //커스텀 구분자 존재 시
            String customDelimiterStr = value.substring(2, value.lastIndexOf("\\n"));
            return new CustomDelimiter(customDelimiterStr);
        }

        return null;
    }

    public String extractCalculationString() {
        if (value.startsWith("//") && value.contains("\\n")) {
            return value.substring(value.lastIndexOf("\\n") + 2);
        }

        return value;
    }
}
