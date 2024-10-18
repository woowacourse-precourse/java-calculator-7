package calculator.delimiter.service;

import calculator.delimiter.domain.Delimiter;
import calculator.delimiter.domain.Delimiters;
import calculator.delimiter.factory.DelimiterFactory;
import calculator.delimiter.pattern.CustomDelimiterPatternMatcher;

import java.util.List;
import java.util.Optional;

public class CustomDelimiterService {

    private final DelimiterFactory delimiterFactory;
    private final CustomDelimiterPatternMatcher customDelimiterPatternMatcher;

    public CustomDelimiterService(
            DelimiterFactory delimiterFactory,
            CustomDelimiterPatternMatcher customDelimiterPatternMatcher) {

        this.delimiterFactory = delimiterFactory;
        this.customDelimiterPatternMatcher = customDelimiterPatternMatcher;
    }

    public List<String> extractNumberStrings(String input) {
        Delimiters delimiters = getDelimiters(input);
        String strippedInput = stripCustomDelimiter(input);
        return delimiters.split(strippedInput);
    }

    private Delimiters getDelimiters(String input) {
        return extractCustomDelimiter(input)
                .map(this::createDelimiters)
                .orElseGet(this::createDelimiters);
    }

    private Optional<Delimiter> extractCustomDelimiter(String value) {
        return Optional.ofNullable(value)
                .flatMap(customDelimiterPatternMatcher::extractDelimiterGroup)
                .map(delimiterFactory::createDelimiter);
    }

    private Delimiters createDelimiters(Delimiter... additionalDelimiters) {
        return delimiterFactory.createDelimiters(additionalDelimiters);
    }

    private String stripCustomDelimiter(String value) {
        return Optional.ofNullable(value)
                .flatMap(customDelimiterPatternMatcher::extractTrimmedGroup)
                .orElse(value);
    }
}

