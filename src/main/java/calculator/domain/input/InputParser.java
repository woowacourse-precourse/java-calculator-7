package calculator.domain.input;

import calculator.domain.delimiter.Delimiters;
import calculator.exception.BusinessException;
import calculator.exception.CalculatorExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    private static final String CUSTOM_DELIMITER_END_SEPARATOR = "\n";
    private static final int INDEX_PUSH_RIGHT = 1;
    public static final String DELIMITER_JOINER = "|";

    private final Delimiters delimiters;

    public InputParser(final Delimiters delimiters) {
        this.delimiters = delimiters;
    }

    public List<Integer> extractNumbersFromInput(final String input) {
        String delimiterRegex = getDelimiterPattern(input);

        String numbers = input.substring(input.indexOf(CUSTOM_DELIMITER_END_SEPARATOR) + INDEX_PUSH_RIGHT);

        return Arrays.stream(numbers.split(delimiterRegex)).map(this::parse).toList();
    }

    private String getDelimiterPattern(String input) {
        return delimiters.getAllDelimiters(input)
                .stream().filter(delimiter -> !delimiter.isBlank())
                .collect(Collectors.joining(DELIMITER_JOINER));
    }

    private int parse(final String input) {
        try {
            int number = Integer.parseInt(input);
            validateNegativeNumber(number);
            return number;
        } catch (Exception e) {
            throw new BusinessException(CalculatorExceptionMessage.INVALID_PARAMETER_EXCEPTION);
        }
    }

    private void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new BusinessException(CalculatorExceptionMessage.INVALID_PARAMETER_EXCEPTION);
        }
    }
}
