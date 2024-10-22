package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private final DelimiterProcessor delimiterProcessor;
    private static final String PATTERN = "//(.*)\\\\n(.*)";
    private String input;

    public StringParser(String input) {
        delimiterProcessor = new DelimiterProcessor(input);
        this.input = input;
    }

    public List<Integer> parse() {
        return convertToIntArray(split());
    }

    private List<Integer> convertToIntArray(List<String> strings) {
        return strings.stream()
                .map(string -> string.isEmpty() ? 0 : Integer.parseInt(string))
                .toList();
    }

    private List<String> split() {
        extractCustomDelimiterIfPresent();

        List<String> strings = List.of(input.split(delimiterProcessor.getDelimiters()));

        validateInput(strings);

        return strings;
    }

    private void extractCustomDelimiterIfPresent() {
        if (delimiterProcessor.containsCustomDelimiter()) {
            input = extractExpression(input);
        }
    }

    private String extractExpression(String input) {
        Matcher matcher = Pattern.compile(PATTERN).matcher(input);
        if (matcher.find()) {
            return matcher.group(2);
        }

        return input;
    }

    private void validateInput(List<String> strings) {
        for (String number : strings) {
            if (!number.isEmpty()) {
                validateNumber(number);
            }
        }
    }

    private void validateNumber(String number) {
        if (isInvalidNumber(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidNumber(String number) {
        return Integer.parseInt(number) < 0 || !Character.isDigit(number.charAt(0));
    }
}