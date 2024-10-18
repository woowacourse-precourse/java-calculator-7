package calculator.delimiter.service;

import calculator.delimiter.domain.Delimiter;
import calculator.delimiter.domain.Delimiters;
import calculator.delimiter.factory.DelimiterFactory;

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

    private final DelimiterFactory delimiterFactory;

    public CustomDelimiterService(DelimiterFactory delimiterFactory) {
        this.delimiterFactory = delimiterFactory;
    }

    public Optional<Delimiter> extract(String value) {
        return Optional.ofNullable(value)
                .map(DELIMITER_PATTERN::matcher)
                .filter(Matcher::find)
                .map(matcher -> delimiterFactory.createDelimiter(matcher.group(DELIMITER_GROUP)));
    }

    public String trimCustomDelimiter(String value) {
        return Optional.ofNullable(value)
                .map(DELIMITER_PATTERN::matcher)
                .filter(Matcher::find)
                .map(matcher -> matcher.group(TRIMMED_GROUP))
                .orElse(value);
    }

    public Delimiters createDelimiters(Delimiter... additionalDelimiters) {
        return delimiterFactory.createDelimiters(additionalDelimiters);
    }
}

