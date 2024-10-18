package calculator.delimiter.service;

import calculator.delimiter.domain.Delimiter;
import calculator.delimiter.factory.DelimiterFactory;
import calculator.delimiter.pattern.CustomDelimiterPatternMatcher;

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

    public Optional<Delimiter> extractCustomDelimiter(String value) {
        return Optional.ofNullable(value)
                .flatMap(customDelimiterPatternMatcher::extractDelimiterGroup)
                .map(delimiterFactory::createDelimiter);
    }

    public String stripCustomDelimiter(String value) {
        return Optional.ofNullable(value)
                .flatMap(customDelimiterPatternMatcher::extractTrimmedGroup)
                .orElse(value);
    }
}

