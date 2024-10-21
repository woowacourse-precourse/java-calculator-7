package calculator.validator;

import calculator.util.MessageSource;
import calculator.util.ValidatorUtil;

public class DelimiterValidator implements Validator {

    private final MessageSource messageSource;

    public DelimiterValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void validate(String value, String customDelimiter) {

        if (customDelimiter == null || customDelimiter.trim().isEmpty()) {
            throw new IllegalArgumentException(messageSource.getMessage("error.invalid_custom_delimiter"));
        }

        if (ValidatorUtil.isContainingNumbers(customDelimiter) || ValidatorUtil.isContainingWhitespace(
                customDelimiter)) {
            throw new IllegalArgumentException(messageSource.getMessage("error.custom_delimiter_contains_numbers"));
        }
    }
}
