package calculator.delimiter.service;

import calculator.delimiter.domain.Delimiter;
import calculator.delimiter.domain.Delimiters;
import calculator.delimiter.factory.DelimiterFactory;

import java.util.List;

public abstract class DelimiterService {

    protected final DelimiterFactory delimiterFactory;
    protected final CustomDelimiterService customDelimiterService;

    public DelimiterService(
            DelimiterFactory delimiterFactory,
            CustomDelimiterService customDelimiterService) {
        this.delimiterFactory = delimiterFactory;
        this.customDelimiterService = customDelimiterService;
    }

    public abstract List<String> splitByDelimiters(String value);

    protected Delimiters getDelimiters(String input) {
        return customDelimiterService.extractCustomDelimiter(input)
                .map(this::createDelimiters)
                .orElseGet(this::createDelimiters);
    }

    protected Delimiters createDelimiters(Delimiter... additionalDelimiters) {
        return delimiterFactory.createDelimiters(additionalDelimiters);
    }
}
