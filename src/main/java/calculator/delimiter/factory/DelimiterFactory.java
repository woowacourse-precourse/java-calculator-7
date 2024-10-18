package calculator.delimiter.factory;

import calculator.delimiter.domain.Delimiter;
import calculator.delimiter.domain.Delimiters;
import calculator.delimiter.validator.DelimiterValidator;

public abstract class DelimiterFactory {

    protected final DelimiterValidator delimiterValidator;

    public DelimiterFactory(DelimiterValidator delimiterValidator) {
        this.delimiterValidator = delimiterValidator;
    }

    public abstract Delimiters createDelimiters(Delimiter... additionalDelimiters);

    public abstract Delimiter createDelimiter(String value);
}
