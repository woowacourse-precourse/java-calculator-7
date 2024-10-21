package calculator.global;

public class Validator {
    public boolean isEmptyOrBlank(String input) {
        if (input == null) return true;
        String trimmedInput = input.trim();
        return trimmedInput.isEmpty();
    }
}
