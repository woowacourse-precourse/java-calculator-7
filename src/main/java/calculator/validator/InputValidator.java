package calculator.validator;

public class InputValidator implements BasicValidator<String> {
    @Override
    public void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
    }
}
