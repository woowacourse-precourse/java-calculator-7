package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final List<String> DEFAULT_DELIMITER = Arrays.asList(",", ":");
    private static final String EXTRACT_DELIMITER_REGEX = "//(.{1})\\\\n";
    private static final String DIGIT_OR_POINT_REGEX = "[0-9.]";
    private static final String NUMERIC_REGEX = "^-?\\d+(\\.\\d+)?$";
    private final String inputString;

    public StringParser(String inputString) {
        this.inputString = inputString;
    }

    public List<Double> extractNumbers() {
        Set<String> delimiters = new HashSet<>(DEFAULT_DELIMITER);
        String expression = this.inputString;

        if (expression.startsWith("//")) {
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
            throw new IllegalArgumentException("커스텀 구분자 입력 양식이 유효하지 않습니다.");
        }
    }

    private void validateInvalidDelimiter(String delimiter) {
        if (delimiter.matches(DIGIT_OR_POINT_REGEX)) {
            throw new IllegalArgumentException("숫자와 마침표(.)는 구분자로 사용할 수 없습니다.");
        }
    }

    private String removeDelimiterDefinition() {
        return this.inputString.replaceAll(EXTRACT_DELIMITER_REGEX, "");
    }

    private List<Double> parseNumbers(String expression, Set<String> delimiters) {
        String delimiterRegEx = "[" + String.join("", delimiters) + "]";
        List<String> stringNumbers = Arrays.asList(expression.split(delimiterRegEx));

        validateNumeric(stringNumbers);
        List<Double> numbers = stringNumbers.stream()
                .map(Double::parseDouble)
                .toList();

        validatePositive(numbers);
        return numbers;
    }

    private void validateNumeric(List<String> stringNumbers) {
        stringNumbers.forEach(string -> {
            if (!string.matches(NUMERIC_REGEX)) {
                throw new IllegalArgumentException("숫자 또는 구분자만 입력 가능합니다.");
            }
        });
    }

    private void validatePositive(List<Double> numbers) {
        numbers.forEach(number -> {
            if (number <= 0) {
                throw new IllegalArgumentException("양수만 입력 가능합니다.");
            }
        });
    }
}
