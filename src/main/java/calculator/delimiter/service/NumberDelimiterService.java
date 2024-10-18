package calculator.delimiter.service;

import calculator.delimiter.domain.Delimiter;
import calculator.delimiter.domain.Delimiters;
import calculator.delimiter.factory.DelimiterFactory;

import java.util.ArrayList;
import java.util.List;

public class NumberDelimiterService extends DelimiterService {

    public NumberDelimiterService(
            DelimiterFactory delimiterFactory,
            CustomDelimiterService customDelimiterService) {

        super(delimiterFactory, customDelimiterService);
    }

    @Override
    public List<String> splitByDelimiters(String value) {
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
