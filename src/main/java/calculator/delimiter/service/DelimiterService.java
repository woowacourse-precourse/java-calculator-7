package calculator.delimiter.service;

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
}
