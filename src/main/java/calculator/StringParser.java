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
    private final String inputString;

    public StringParser(String inputString) {
        this.inputString = inputString;
    }

    public List<Integer> extractNumbers() {
        String expression = this.inputString;
        Set<String> delimiter = new HashSet<>(DEFAULT_DELIMITER);

        String customDelimiter = extractCustomDelimiter();
        if (customDelimiter != null) {
            expression = removeDelimiterDefinition();
            delimiter.add(customDelimiter);
        }

        return getNumbers(expression, delimiter);
    }

    private String extractCustomDelimiter() {
        Pattern pattern = Pattern.compile(EXTRACT_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(this.inputString);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    private String removeDelimiterDefinition() {
        return this.inputString.replaceAll(EXTRACT_DELIMITER_REGEX, "");
    }

    private List<Integer> getNumbers(String expression, Set<String> delimiter) {
        String delimiterRegEx = "[" + String.join("", delimiter) + "]";
        String[] stringNumbers = expression.split(delimiterRegEx);

        return Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
