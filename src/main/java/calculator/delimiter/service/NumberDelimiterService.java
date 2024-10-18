package calculator.delimiter.service;

import calculator.delimiter.factory.DelimiterFactory;

public abstract class NumberDelimiterService extends DelimiterService {

    public NumberDelimiterService(
            DelimiterFactory delimiterFactory,
            CustomDelimiterService customDelimiterService) {

        super(delimiterFactory, customDelimiterService);
    }
}
