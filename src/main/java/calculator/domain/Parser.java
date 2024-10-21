package calculator.domain;

import static calculator.domain.constant.Delimiter.CUSTOM_END;
import static calculator.domain.constant.Delimiter.CUSTOM_START;
import static calculator.domain.constant.Delimiter.DEFAULT;
import static calculator.domain.constant.errorMessage.ValueError.INVALID_VALUE_FORMAT;
import static calculator.domain.constant.errorMessage.ValueError.MINUS_VALUE;
import static calculator.domain.constant.errorMessage.ValueError.OUT_OF_RANGE_VALUE;

import calculator.global.exception.CalculatorException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final String DEFAULT_DELIMITERS = DEFAULT.getDelimiter();
    private static final String CUSTOM_DELIMITER_START = CUSTOM_START.getDelimiter();
    private static final String CUSTOM_DELIMITER_END = CUSTOM_END.getDelimiter();

    public List<Integer> parseInput(String targetInput) {
        String sanitizedInput = getSanitizeInput(targetInput);
        String delimiters = getDelimiters(targetInput);

        return splitAndParse(sanitizedInput, delimiters);
    }

    private String getSanitizeInput(String targetInput) {
        InputSanitizer inputSanitizer = new InputSanitizer();
        return inputSanitizer.sanitizeInput(targetInput, CUSTOM_DELIMITER_START, CUSTOM_DELIMITER_END);
    }

    private String getDelimiters(String targetInput) {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        return delimiterExtractor.extractDelimiters(targetInput, DEFAULT_DELIMITERS, CUSTOM_DELIMITER_START,
                CUSTOM_DELIMITER_END);
    }

    private List<Integer> splitAndParse(String input, String delimiters) {

        if (input.isEmpty()) {
            return Arrays.asList(0);
        }

        String[] tokens = input.split(delimiters);

        return Arrays.stream(tokens)
                .map(String::trim)
                .peek(this::validateNoInternalWhitespace)
                .map(this::parseValue)
                .collect(Collectors.toList());
    }


    private void validateNoInternalWhitespace(String token) {
        if (token.contains(" ")) {
            throw new CalculatorException(INVALID_VALUE_FORMAT);
        }
    }

    private int parseValue(String token) {
        if (isEmptyValue(token)) {
            return 0;
        }

        long number = parseLongValue(token);
        checkOutOfRange(number);
        int intValue = convertToInt(number);
        checkNegativeValue(intValue);

        return intValue;
    }

    private boolean isEmptyValue(String token) {
        return token.isEmpty();
    }

    private long parseLongValue(String token) {
        try {
            return Long.parseLong(token);
        } catch (NumberFormatException e) {
            throw new CalculatorException(INVALID_VALUE_FORMAT);
        }
    }

    private void checkOutOfRange(long number) {
        if (number < Integer.MIN_VALUE || number > Integer.MAX_VALUE) {
            throw new CalculatorException(OUT_OF_RANGE_VALUE);
        }
    }

    private int convertToInt(long number) {
        return (int) number;
    }

    private void checkNegativeValue(int value) {
        if (value < 0) {
            throw new CalculatorException(MINUS_VALUE);
        }
    }
}
