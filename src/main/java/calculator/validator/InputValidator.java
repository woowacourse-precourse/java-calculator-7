package calculator.validator;

public class InputValidator {
    private String input;

    public InputValidator(String input) {
        this.input = input;
        validate();
    }

    private void validate() {
        if(isInputEmpty()) return;
        CustomSeparatorValidator customSeparatorValidator = new CustomSeparatorValidator(input);
        AnotherLetterValidator anotherLetterValidator = new AnotherLetterValidator(input);
        ConsecutiveLetterValidator consecutiveLetterValidator = new ConsecutiveLetterValidator(input);
    }

    private boolean isInputEmpty() {
        if(input.isEmpty()) return true;
        if(input.charAt(0)=='/') return input.substring(5).isEmpty();
        return false;
    }

}
