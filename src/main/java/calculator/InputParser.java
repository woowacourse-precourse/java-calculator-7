package calculator;

public class InputParser {

    public Character extractCustomDelimiter(String input) {
        if (input.startsWith("//") && input.contains("\\n")) { //커스텀 구분자 존재 시
            String customDelimiterStr = input.substring(2, input.lastIndexOf("\\n"));
            validateCustomDelimiterLength(customDelimiterStr);

            return customDelimiterStr.charAt(0);
        }

        return null;
    }



    private void validateCustomDelimiterLength(String customDelimiterStr) {
        if (customDelimiterStr.length() != 1) { //커스텀 구분자의 길이가 1인지 확인
            throw new IllegalArgumentException();
        }
    }

    public String extractCalculationString(String input, Character customDelimiter) {
        if (customDelimiter != null) {
            return input.substring(input.lastIndexOf("\\n") + 2);
        }

        return input;
    }
}
