package calculator;

public class InputParser {

    public CustomDelimiter extractCustomDelimiter(String input) {
        if (input.startsWith("//") && input.contains("\\n")) { //커스텀 구분자 존재 시
            String customDelimiterStr = input.substring(2, input.lastIndexOf("\\n"));
            return new CustomDelimiter(customDelimiterStr);
        }

        return null;
    }

    public String extractCalculationString(String input, CustomDelimiter customDelimiter) {
        if (customDelimiter != null) {
            return input.substring(input.lastIndexOf("\\n") + 2);
        }

        return input;
    }
}
