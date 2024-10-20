package calculator.application;

import java.util.Set;

public final class DelimiterParser {
    private static final String CUSTOM_DELIMITER_START_WORD = "//";
    private static final String CUSTOM_DELIMITER_END_WORD = "\\n";

    private final DelimiterValidator delimiterValidator;

    private String parsed;

    public DelimiterParser(DelimiterValidator delimiterValidator) {
        this.delimiterValidator = delimiterValidator;
    }

    public DelimiterList parseToDelimiterList(final String value) {
        this.parsed = value;

        if (value.startsWith(CUSTOM_DELIMITER_START_WORD)) {
            final var delimiterEndIndex = value.indexOf(CUSTOM_DELIMITER_END_WORD);
            final var customDelimiters = value.substring(CUSTOM_DELIMITER_START_WORD.length(), delimiterEndIndex);
            inputValueParsed(value);
            return createCustomDelimiters(customDelimiters);
        }

        return DelimiterSpecification.createDefaultdelimiterList();
    }

    public String getParsed() {
        return parsed;
    }

    private void inputValueParsed(final String value) {
        final var delimiterEndIndex = value.indexOf(CUSTOM_DELIMITER_END_WORD);
        this.parsed = value.substring(delimiterEndIndex + CUSTOM_DELIMITER_END_WORD.length());

        delimiterValidator.validLastCharacter(this.parsed);
    }

    private DelimiterList createCustomDelimiters(final String customDelimiter) {
        final var split = customDelimiter.split("");
        final var defaultDelimiterList = DelimiterSpecification.createDefaultdelimiterList();
        delimiterValidator.validCustomDelimiter(split);
        delimiterValidator.validCustomDelimiterSize(split);
        defaultDelimiterList.add(Set.of(Delimiter.from(split[0])));

        return defaultDelimiterList;
    }
}