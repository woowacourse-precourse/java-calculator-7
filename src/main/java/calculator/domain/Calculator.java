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

    private String extractNumbersPart(String input) {
        return input.substring(input.indexOf("\\n") + 2);
    }

    private String[] splitNumbers(String input, String separator) {
        for (char delimiter : separator.toCharArray()) {
            input = input.replace(String.valueOf(delimiter), " ");
        }
        return input.split("\\s+");
    }
}
