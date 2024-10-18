package calculator.delimiter.factory;

import calculator.delimiter.custom.validator.DelimiterValidator;
import calculator.delimiter.domain.Delimiter;
import calculator.delimiter.domain.Delimiters;

public abstract class DelimiterFactory {

    protected final DelimiterValidator delimiterValidator;

    public DelimiterFactory(DelimiterValidator delimiterValidator) {
        this.delimiterValidator = delimiterValidator;
    }

    public abstract Delimiters createDelimiters(Delimiter... additionalDelimiters);

    public abstract Delimiter createDelimiter(String value);
}
