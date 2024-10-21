package calculator.validator;

public class InputValidator {
    public InputValidator(String input) {
        validate(input);
    }

    private void validate(String input) {
        if (isInputEmpty(input)) return;
        CustomSeparatorValidator customSeparatorValidator = new CustomSeparatorValidator(input);
        AnotherLetterValidator anotherLetterValidator = new AnotherLetterValidator(input);
        ConsecutiveLetterValidator consecutiveLetterValidator = new ConsecutiveLetterValidator(input);
        EdgeCharValidator edgeCharValidator = new EdgeCharValidator(input);
    }

    private boolean isInputEmpty(String input) {
        if (input.isEmpty()) return true;
        if (input.charAt(0) == '/') return input.substring(5).isEmpty();
        return false;
    }

}
