package calculator.model;

import calculator.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DefaultDelimiterParsingStrategy implements ParsingStrategy {
    private final Delimiters delimiters;

    public DefaultDelimiterParsingStrategy(final Delimiters delimiters) {
        this.delimiters = delimiters;
    }

    @Override
    public List<Integer> parse(final String input) {
        List<String> result = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, delimiters.toConcatenatedString());
        while (stringTokenizer.hasMoreTokens()) {
            result.add(stringTokenizer.nextToken());
        }
        return result.stream().map(this::getPositiveNumber).toList();
    }

    private Integer getPositiveNumber(final String number) {
        int integerNumber = Integer.parseInt(number);
        if (integerNumber <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_OUT_OF_RANGE.getMessage());
        }
        return integerNumber;
    }
}