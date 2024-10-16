package calculator.domain;

public class Calculator {
    private boolean isInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private boolean isCustomSeparator(String input) {
        return input.startsWith("//");
    }
}
