package calculator.model.delimiter.service;

import calculator.model.custom_delimiter.service.CustomDelimiterService;
import calculator.model.delimiter.factory.DelimitersFactory;

public abstract class NumberDelimiterService extends DelimiterService {

    public NumberDelimiterService(
            DelimitersFactory delimitersFactory,
            CustomDelimiterService customDelimiterService) {

        super(delimitersFactory, customDelimiterService);
    }
}
