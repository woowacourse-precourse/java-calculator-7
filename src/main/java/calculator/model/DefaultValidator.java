package calculator.model;

import static calculator.constant.DelimiterConstants.DEFAULT_DELIMITER_REGEX;
import static calculator.constant.ErrorMessages.INVALID_NUMBER_FORMAT;
import static calculator.constant.ErrorMessages.NEGATIVE_NUMBER_NOT_ALLOWED;

public class DefaultValidator implements Validator{

    @Override
    public ParsedInput validate(String input) {
        String[] numbers = input.split(DEFAULT_DELIMITER_REGEX);
        validateNumbers(numbers);

        return new ParsedInput(DEFAULT_DELIMITER_REGEX, input);
    }

    private static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;
            }

            try {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException(NEGATIVE_NUMBER_NOT_ALLOWED);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
            }
        }
    }
}
