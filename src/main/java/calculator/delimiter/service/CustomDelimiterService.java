package calculator.delimiter.service;

import calculator.delimiter.domain.Delimiter;
import calculator.delimiter.validator.CustomDelimiterValidator;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterService {

    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final String CUSTOM_DELIMITER_SUFFIX = "\\\\n";
    private final int DELIMITER_GROUP = 1;
    private final int TRIMMED_GROUP = 2;
    private final Pattern DELIMITER_PATTERN = Pattern.compile(
            "^" + CUSTOM_DELIMITER_PREFIX + "(.*)" + CUSTOM_DELIMITER_SUFFIX + "(.*)"
    );

    private final CustomDelimiterValidator customDelimiterValidator;

    public CustomDelimiterService(CustomDelimiterValidator customDelimiterValidator) {
        this.customDelimiterValidator = customDelimiterValidator;
    }

    public Optional<Delimiter> extract(String value) {
        return Optional.ofNullable(value)
                .map(DELIMITER_PATTERN::matcher)
                .filter(Matcher::find)
                .map(matcher -> {
                    String extracted = matcher.group(DELIMITER_GROUP);
                    customDelimiterValidator.validate(extracted);
                    return new Delimiter(extracted);
                });
    }

    public String trimCustomDelimiter(String value) {
        return Optional.ofNullable(value)
                .map(DELIMITER_PATTERN::matcher)
                .filter(Matcher::find)
                .map(matcher -> matcher.group(TRIMMED_GROUP))
                .orElse(value);
    }
}

