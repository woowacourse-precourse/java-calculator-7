package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private static final String REGEX_START = "[";
    private static final String REGEX_END = "]";
    private static final String EMPTY_TEXT = "";

    private List<Integer> numbers = new ArrayList<>();

    public Numbers(final String input, final String separators) {
        extractNumbers(input, separators);
    }

    private void extractNumbers(final String input, final String separators) {
        String regex = new StringBuilder()
                .append(REGEX_START + separators + REGEX_END).toString();

        if (input.contains("//")) {
            String removeCustomOperator = input.replaceAll("//", "").replaceAll("\\\\n", "");
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
