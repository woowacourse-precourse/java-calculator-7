package calculator.domain;

import static calculator.domain.constant.errorMessage.ValueError.INVALID_VALUE_FORMAT;
import static calculator.domain.constant.errorMessage.ValueError.MINUS_VALUE;

import calculator.global.exception.CalculatorException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

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
                .map(this::parseValue)
                .collect(Collectors.toList());
    }

    private int parseValue(String token) {
        if (token.isEmpty()) {
            return 0;
        }

        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new CalculatorException(MINUS_VALUE);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new CalculatorException(INVALID_VALUE_FORMAT);
        }
    }
}
