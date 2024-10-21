package calculator.model.delimiter.factory;

import calculator.model.custom_delimiter.validator.DelimiterValidator;
import calculator.model.delimiter.domain.Delimiter;

public abstract class DelimiterFactory {

    protected final DelimiterValidator delimiterValidator;

    public DelimiterFactory(DelimiterValidator delimiterValidator) {
        this.delimiterValidator = delimiterValidator;
    }

    public abstract Delimiter createDelimiter(String value);
}
