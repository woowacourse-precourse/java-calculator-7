package calculator.validator;

public class InputValidator {
    private String input;

    public InputValidator(String input) {
        this.input = input;
        validate();
    }

    private void validate() {
        CustomSeparatorValidator customSeparatorValidator = new CustomSeparatorValidator(input);
        AnotherLetterValidator anotherLetterValidator = new AnotherLetterValidator(input);
        ConsecutiveLetterValidator consecutiveLetterValidator = new ConsecutiveLetterValidator(input);
    }

}
