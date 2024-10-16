package calculator.domain;

import java.util.Arrays;

public class InputParser {

    private static final String CUSTOM_DELIMITER_END_SEPARATOR = "\n";
    private static final int INDEX_PUSH_RIGHT = 1;

    private final Delimiter delimiter;

    public InputParser(final Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public Integer[] splitIncludeCustomDelimiter(final String input) {

        String[] inputSplitCustomDelimiter = input.substring(input.indexOf(CUSTOM_DELIMITER_END_SEPARATOR) + INDEX_PUSH_RIGHT)
                .split(delimiter.getAllDelimiters(input));

        return Arrays.stream(inputSplitCustomDelimiter)
                .map(this::parse)
                .toArray(Integer[]::new);
    }

    private int parse(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }
}
