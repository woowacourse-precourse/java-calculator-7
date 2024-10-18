package calculator.delimiter.factory;

import calculator.delimiter.custom.validator.DelimiterValidator;
import calculator.delimiter.domain.Delimiter;
import calculator.delimiter.domain.Delimiters;

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
        return new Delimiter(value);
    }
}
