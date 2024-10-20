package calculator.domain;

import static calculator.constant.NumberRange.MAX;
import static calculator.constant.NumberRange.MIN;

import calculator.util.convertor.StringConvertor;
import calculator.util.parser.StringParser;
import calculator.util.validator.StringValidator;
import java.util.List;

public class Numbers<T extends Number> {

    private final List<T> values;

    private Numbers(final List<T> values) {
        this.values = values;
    }

    public static Numbers<Integer> ofInteger(
            final String inputString,
            final StringConvertor<Integer> stringConvertor,
            final StringParser stringParser,
            final StringValidator stringValidator) {
        stringValidator.validateFormat(inputString);
        stringValidator.validateRange(inputString, MIN, MAX);
        final String customDelimiter = stringParser.extractCustomDelimiter(inputString);
        final String delimiterRegex = stringParser.getDelimiterRegex(customDelimiter);
        final List<Integer> numbers = stringConvertor.convertToListWithDelimiter(
                stringParser.removeCustomDelimiterFormat(inputString), delimiterRegex);
        return new Numbers<>(numbers);
    }

    public int getSize() {
        return values.size();
    }

    public T getNumber(final int idx) {
        return values.get(idx);
    }

}
