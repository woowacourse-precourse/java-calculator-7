package calculator.model.delimiter.service;

import calculator.model.custom_delimiter.service.CustomDelimiterService;
import calculator.model.delimiter.factory.DelimiterFactory;

public abstract class NumberDelimiterService extends DelimiterService {

    public NumberDelimiterService(
            DelimiterFactory delimiterFactory,
            CustomDelimiterService customDelimiterService) {

        super(delimiterFactory, customDelimiterService);
    }
}
