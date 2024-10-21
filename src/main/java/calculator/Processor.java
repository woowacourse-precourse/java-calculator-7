package calculator;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private List<String> delimiters = new ArrayList<>(List.of(",", ":"));
    private String input;
    private Numbers numbers;

    public Processor(String input) {
        this.input = input;
    }

    public int execute() {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            String customDelimiter = extractCustomDelimiter();
            delimiters.add(customDelimiter);
        }

        String[] splitInput = Splitter.splitByDelimiters(input, delimiters);
        Validator.isAllNumbers(splitInput);

        numbers = new Numbers(Converter.toIntArray(splitInput));

        return numbers.calculateSum();
    }

    public String extractCustomDelimiter() {
        int startIndexOfCustomDelimiter = CUSTOM_DELIMITER_PREFIX.length();
        int endIndexOfCustomDelimiter = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        String customDelimiter = input.substring(startIndexOfCustomDelimiter, endIndexOfCustomDelimiter);

        int endOfDelimiterSection = endIndexOfCustomDelimiter + CUSTOM_DELIMITER_SUFFIX.length();
        input = input.substring(endOfDelimiterSection);

        return customDelimiter;
    }
}
