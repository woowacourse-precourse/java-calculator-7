package calculator.delimiter.service;

import calculator.delimiter.domain.Delimiter;
import calculator.delimiter.domain.Delimiters;
import calculator.delimiter.factory.DelimiterFactory;

import java.util.ArrayList;
import java.util.List;

public class DelimiterService {

    private final DelimiterFactory delimiterFactory;
    private final CustomDelimiterService customDelimiterService;

    public DelimiterService(
            DelimiterFactory delimiterFactory,
            CustomDelimiterService customDelimiterService) {
        this.delimiterFactory = delimiterFactory;
        this.customDelimiterService = customDelimiterService;
    }

    public List<String> extractNumberStrings(String value) {
        Delimiters delimiters = getDelimiters(value);
        String strippedInput = customDelimiterService.stripCustomDelimiter(value);

        return new ArrayList<>(List.of(strippedInput.split(delimiters.splitRegex())));
    }

    private Delimiters getDelimiters(String input) {
        return customDelimiterService.extractCustomDelimiter(input)
                .map(this::createDelimiters)
                .orElseGet(this::createDelimiters);
    }

    private Delimiters createDelimiters(Delimiter... additionalDelimiters) {
        return delimiterFactory.createDelimiters(additionalDelimiters);
    }
}
