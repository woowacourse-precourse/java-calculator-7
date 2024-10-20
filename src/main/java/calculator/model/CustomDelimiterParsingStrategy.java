package calculator.model;

import calculator.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CustomDelimiterParsingStrategy implements ParsingStrategy {
    private final Delimiters delimiters;

    public CustomDelimiterParsingStrategy() {
        this.delimiters = new Delimiters();
    }

    @Override
    public List<Integer> parse(final String input) {
        delimiters.addCustomDelimiter(input);
        int offset = Integer.parseInt(DelimiterConstant.CUSTOM_VALIDATOR_EXPRESSION_LENGTH.getValue());
        String substring = input.substring(offset);
        List<String> result = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(substring, delimiters.toConcatenatedString());
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