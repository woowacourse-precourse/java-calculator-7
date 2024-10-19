package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringParser {
    private static final List<String> DEFAULT_DELIMITER = Arrays.asList(",", ":");
    private static final String EXTRACT_DELIMITER_REGEX = "//(.*?)\\\\n";
    private static final String NON_DIGIT_REGEX = ".*\\D.*";
    private final String inputString;

    public StringParser(String inputString) {
        this.inputString = inputString;
    }

    public List<Integer> extractNumbers() {
        Set<String> delimiters = new HashSet<>(DEFAULT_DELIMITER);
        String expression = this.inputString;

        String customDelimiter = extractCustomDelimiter();
        if (customDelimiter != null) {
            delimiters.add(customDelimiter);
            expression = removeDelimiterDefinition();
        }

        return parseNumbers(expression, delimiters);
    }

    private String extractCustomDelimiter() {
        // TODO: validate input string format
        // TODO: validate custom delimiter is number

        Pattern pattern = Pattern.compile(EXTRACT_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(this.inputString);

        return matcher.find() ? matcher.group(1) : null;
    }

    private String removeDelimiterDefinition() {
        return this.inputString.replaceAll(EXTRACT_DELIMITER_REGEX, "");
    }

    private List<Integer> parseNumbers(String expression, Set<String> delimiters) {
        String delimiterRegEx = "[" + String.join("", delimiters) + "]";
        String[] stringNumbers = expression.split(delimiterRegEx);

        validateNumeric(stringNumbers);
        // TODO: validate positive integer

        return Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateNumeric(String[] stringNumbers) {
        boolean existNonNumeric = Arrays.stream(stringNumbers).anyMatch(s -> s.matches(NON_DIGIT_REGEX));
        if (existNonNumeric) {
            throw new IllegalArgumentException();
        }
    }
}
