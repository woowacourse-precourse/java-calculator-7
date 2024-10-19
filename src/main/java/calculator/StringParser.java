package calculator;

import java.util.List;
import java.util.Optional;

public class StringParser {

    private final DelimiterProcessor delimiterProcessor;
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
        return Optional.ofNullable(input)
                .map(i -> i.substring(i.indexOf("\n") + 1))
                .orElse("");
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