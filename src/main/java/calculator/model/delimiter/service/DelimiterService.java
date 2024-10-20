package calculator.model.delimiter.service;

import calculator.model.custom_delimiter.service.CustomDelimiterService;
import calculator.model.delimiter.domain.Delimiter;
import calculator.model.delimiter.domain.Delimiters;
import calculator.model.delimiter.factory.DelimitersFactory;

import java.util.List;

public abstract class DelimiterService {

    protected final DelimitersFactory delimitersFactory;
    protected final CustomDelimiterService customDelimiterService;

    public DelimiterService(
            DelimitersFactory delimitersFactory,
            CustomDelimiterService customDelimiterService) {
        this.delimitersFactory = delimitersFactory;
        this.customDelimiterService = customDelimiterService;
    }

    public abstract List<String> splitByDelimiters(String value);

    protected Delimiters getDelimiters(String value) {
        return customDelimiterService.extractCustomDelimiter(value)
                .map(this::createDelimiters)
                .orElseGet(this::createDelimiters);
    }

    protected Delimiters createDelimiters(Delimiter... additionalDelimiters) {
        return delimitersFactory.createDelimiters(additionalDelimiters);
    }
}
