package calculator.model.delimiter.factory;

import calculator.model.custom_delimiter.validator.DelimiterValidator;
import calculator.model.delimiter.domain.Delimiter;
import calculator.util.pattern.PatternUtils;

public class DefaultDelimiterFactory extends DelimiterFactory {

    public DefaultDelimiterFactory(DelimiterValidator delimiterValidator) {
        super(delimiterValidator);
    }

    @Override
    public Delimiter createDelimiter(String value) {
        delimiterValidator.validate(value);
        value = PatternUtils.escapeSpecialCharacters(value);
        return new Delimiter(value);
    }
}
