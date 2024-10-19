package calculator.view.input.validator;

import static calculator.view.input.validator.ValidationMessage.INPUT_NEGATIVE_NUMERIC;
import static calculator.view.input.validator.ValidationMessage.INVALID_INPUT_STRING;

public class NumberValidator {
    private static final String WHITESPACE = " ";

    public void validate(String input) {
        validContainsNegativeNumber(input);
        validContainsNonNumber(input);
    }

    private void validContainsNegativeNumber(String input) {
        String[] inputSplit = input.split(WHITESPACE);

        for (String s : inputSplit) {
            if (s.startsWith("-")) {
                throw new IllegalArgumentException(INPUT_NEGATIVE_NUMERIC.getMessage());
            }
        }
    }

    private void validContainsNonNumber(String input) {
        String[] inputSplit = input.split(WHITESPACE);

        for (String s : inputSplit) {
            if (s.chars().anyMatch(c -> !Character.isDigit(c))) {
                throw new IllegalArgumentException(INVALID_INPUT_STRING.getMessage());
            }
        }
    }
}
