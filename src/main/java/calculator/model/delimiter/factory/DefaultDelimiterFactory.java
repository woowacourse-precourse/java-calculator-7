package calculator.model.delimiter.factory;

import calculator.model.custom_delimiter.validator.DelimiterValidator;
import calculator.model.delimiter.domain.Delimiter;
import calculator.model.delimiter.domain.Delimiters;
import calculator.util.pattern.PatternUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultDelimiterFactory extends DelimiterFactory {

    private final List<Delimiter> DEFAULT_DELIMITERS = List.of(
            new Delimiter(","),
            new Delimiter(":")
    );

    public DefaultDelimiterFactory(DelimiterValidator delimiterValidator) {
        super(delimiterValidator);
    }

    @Override
    public Delimiters createDelimiters(Delimiter... additionalDelimiters) {
        List<Delimiter> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        delimiters.addAll(Arrays.asList(additionalDelimiters));
        return new Delimiters(delimiters);
    }

    @Override
    public Delimiter createDelimiter(String value) {
        delimiterValidator.validate(value);
        value = PatternUtils.escapeSpecialCharacters(value);
        return new Delimiter(value);
    }
}
