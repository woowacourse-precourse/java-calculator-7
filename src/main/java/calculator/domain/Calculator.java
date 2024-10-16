package calculator.domain;

public class Calculator {
    private boolean isInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private boolean isCustomSeparator(String input) {
        return input.startsWith("//");
    }

    private String extractCustomSeparator(String input, String separator) {
        int newlineIndex = input.indexOf("\\n");
        String customSeparator = input.substring(2, newlineIndex);
        return separator + customSeparator;
    }
}
