package calculator.validator;

import calculator.util.MessageSource;
import java.util.regex.Pattern;

public class ValueValidate implements Validator {

    private final MessageSource messageSource;

    public ValueValidate(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void validate(String value, String delimiter) {

        if (value.contains(" ")) {
            throw new IllegalArgumentException(messageSource.getMessage("error.input_contains_whitespace"));
        }

        if (containsInvalidCharacters(value, delimiter)) {
            throw new IllegalArgumentException(messageSource.getMessage("error.input_contains_invalid_characters"));
        }
    }

    private boolean containsInvalidCharacters(String value, String delimiter) {
        String invalidCharactersRegex = "[^" + Pattern.quote(delimiter) + "\\d]";
        return Pattern.compile(invalidCharactersRegex).matcher(value).find();
    }
}
