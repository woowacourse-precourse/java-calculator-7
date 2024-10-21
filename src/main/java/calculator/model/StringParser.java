package calculator.model;

import calculator.constant.ErrorMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final List<String> DEFAULT_DELIMITER = Arrays.asList(",", ":");
    private static final String CUSTOM_DELIMITER_START_MARK = "//";
    private static final String EXTRACT_DELIMITER_REGEX = "//(.)\\\\n";
    private static final String DIGIT_OR_POINT_REGEX = "[0-9.]";
    private static final String NUMERIC_REGEX = "^-?\\d+(\\.\\d+)?$";
    private final String inputString;

    public StringParser(String inputString) {
        this.inputString = inputString;
    }

    public List<Double> extractNumbers() {
        Set<String> delimiters = new HashSet<>(DEFAULT_DELIMITER);
        String expression = this.inputString;

        if (expression.startsWith(CUSTOM_DELIMITER_START_MARK)) {
            String customDelimiter = extractCustomDelimiter();
            delimiters.add(customDelimiter);
            expression = removeDelimiterDefinition();
        }

        return parseNumbers(expression, delimiters);
    }

    private String extractCustomDelimiter() {
        Pattern pattern = Pattern.compile(EXTRACT_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(this.inputString);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            validateInvalidDelimiter(delimiter);
            return delimiter;
        } else {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }
    }

    private void validateInvalidDelimiter(String delimiter) {
        if (delimiter.matches(DIGIT_OR_POINT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_VALUE.getMessage());
        }
    }

    private String removeDelimiterDefinition() {
        return this.inputString.replaceAll(EXTRACT_DELIMITER_REGEX, "");
    }

    private List<Double> parseNumbers(String expression, Set<String> delimiters) {
        if (expression.isEmpty()) {
            return new ArrayList<>();
        }

        String delimiterRegEx = "[" + String.join("", delimiters) + "]";
        List<String> stringNumbers = Arrays.asList(expression.split(delimiterRegEx));

        List<Double> numbers = convertStringToDouble(stringNumbers);
        validatePositiveDoubleRange(numbers);

        return numbers;
    }

    private List<Double> convertStringToDouble(List<String> stringNumbers) {
        validateNumeric(stringNumbers);
        return stringNumbers.stream()
                .map(Double::parseDouble)
                .toList();
    }

    private void validateNumeric(List<String> stringNumbers) {
        stringNumbers.forEach(string -> {
            if (!string.matches(NUMERIC_REGEX)) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_NON_NUMERIC_CHARACTER.getMessage());
            }
        });
    }

    private void validatePositiveDoubleRange(List<Double> numbers) {
        numbers.forEach(number -> {
            if (number <= 0) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_NON_POSITIVE_NUMBER.getMessage());
            } else if (number > Double.MAX_VALUE) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_DOUBLE_OVERFLOW_NUMBER.getMessage());
            }
        });
    }
}
