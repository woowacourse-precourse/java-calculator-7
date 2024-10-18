package calculator.domain;

import static calculator.constant.Delimiter.COLON;
import static calculator.constant.Delimiter.COMMA;
import static calculator.constant.NumberRange.MAX;
import static calculator.constant.NumberRange.MIN;

import calculator.util.convertor.StringConvertor;
import calculator.util.parser.StringParser;
import calculator.util.validator.StringValidator;
import java.util.List;

public class Numbers<T extends Number> {

    private final List<T> numbers;

    private Numbers(final List<T> numbers) {
        this.numbers = numbers;
    }

    public static Numbers<Integer> ofInteger(
            final String inputString,
            final StringConvertor<Integer> stringConvertor,
            final StringParser stringParser,
            final StringValidator stringValidator) {
        stringValidator.validateFormat(inputString);
        stringValidator.validateRange(inputString, MIN, MAX);
        final String customDelimiter = stringParser.extractCustomDelimiter(inputString);
        final String delimiter = "[" + COMMA + COLON + customDelimiter + "]";
        final List<Integer> numbers = stringConvertor.convertToListWithDelimiter(
                stringParser.removeCustomDelimiterFormat(inputString), delimiter);
        return new Numbers<>(numbers);
    }

    public int getSize() {
        return numbers.size();
    }

    public T getNumber(final int idx) {
        return numbers.get(idx);
    }

}
