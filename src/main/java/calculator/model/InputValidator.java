package calculator.model;

public class InputValidator {
    public boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
