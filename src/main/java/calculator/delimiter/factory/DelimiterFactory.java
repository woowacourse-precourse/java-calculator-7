package calculator.delimiter.factory;

import calculator.delimiter.domain.Delimiter;
import calculator.delimiter.domain.Delimiters;
import calculator.delimiter.validator.CustomDelimiterValidator;

public abstract class DelimiterFactory {

    protected final CustomDelimiterValidator customDelimiterValidator;

    public DelimiterFactory(CustomDelimiterValidator customDelimiterValidator) {
        this.customDelimiterValidator = customDelimiterValidator;
    }

    public abstract Delimiters createDelimiters(Delimiter... additionalDelimiters);

    public abstract Delimiter createDelimiter(String value);
}
