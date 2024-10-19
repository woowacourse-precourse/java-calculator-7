package calculator.validation;

public class InputValidator {

    public boolean isInvalidInput(String input) {
        return input == null || input.isEmpty();
    }

}