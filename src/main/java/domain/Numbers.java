package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constants.Constants.*;

public class Numbers {

    private static final String REGEX_START = "[";
    private static final String ESCAPE_TEXT = "\\";
    private static final String REGEX_END = "]";

    private List<Integer> numbers = new ArrayList<>();

    public Numbers(final String input, final String delimiters) {
        extractNumbers(input, delimiters);
    }

    private void extractNumbers(final String input, final String delimiters) {
        String regex = new StringBuilder()
                .append(REGEX_START + ESCAPE_TEXT + delimiters + REGEX_END).toString();

        if (input.contains(CUSTOM_START_TEXT)) {
            String removeCustomOperator = input.replaceAll(CUSTOM_START_TEXT, EMPTY_TEXT)
                    .replaceAll(REGEX_CUSTOM_END_TEXT, EMPTY_TEXT);
            convertNumber(removeCustomOperator, regex);
            return;
        }

        convertNumber(input, regex);
    }

    private void convertNumber(final String input, final String regex) {
        this.numbers = Arrays.stream(input.split(regex)).map(value -> {
            if (EMPTY_TEXT.equals(value)) {
                return 0;
            }
            return Integer.parseInt(value);
        }).collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
