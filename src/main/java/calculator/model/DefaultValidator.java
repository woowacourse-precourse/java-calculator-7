package calculator.model;

import calculator.util.NumberValidator;

import static calculator.constant.DelimiterConstants.DEFAULT_DELIMITER_REGEX;

public class DefaultValidator implements Validator {

    @Override
    public ParsedInput validate(String input) {
        String[] numbers = input.split(DEFAULT_DELIMITER_REGEX);
        NumberValidator.validateNumbers(numbers);

        return new ParsedInput(DEFAULT_DELIMITER_REGEX, input);
    }
}
