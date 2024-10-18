package calculator;

public class InputString {
    private final String value;

    public InputString(String input) {
        this.value = input;
    }

    public CustomDelimiter extractCustomDelimiter() {
        if (isValueHasCustomDelimiter()) {
            String customDelimiterStr = value.substring(2, value.lastIndexOf("\\n"));
            return new CustomDelimiter(customDelimiterStr);
        }

        return null;
    }

    public CalculationString extractCalculationString() {
        String calculationString = value;
        if (isValueHasCustomDelimiter()) {
            calculationString = value.substring(value.lastIndexOf("\\n") + 2);
        }

        return new CalculationString(calculationString);
    }

    private boolean isValueHasCustomDelimiter() {
        return value.startsWith("//") && value.contains("\\n");
    }
}
