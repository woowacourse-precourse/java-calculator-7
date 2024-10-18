package calculator.model.delimiter.factory;

import calculator.model.custom_delimiter.validator.DelimiterValidator;
import calculator.model.delimiter.domain.Delimiter;
import calculator.model.delimiter.domain.Delimiters;

public abstract class DelimiterFactory {

    protected final DelimiterValidator delimiterValidator;

    public DelimiterFactory(DelimiterValidator delimiterValidator) {
        this.delimiterValidator = delimiterValidator;
    }

    public abstract Delimiters createDelimiters(Delimiter... additionalDelimiters);

    public abstract Delimiter createDelimiter(String value);
}
