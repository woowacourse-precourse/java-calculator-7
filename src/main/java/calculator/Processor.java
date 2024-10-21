package calculator;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private List<String> delimiters = new ArrayList<>(List.of(",", ":"));
    private String input;

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

        int[] numbers = Converter.toIntArray(splitInput);
        Validator.isAllPositiveNumbers(numbers);

        return Calculator.calculateSum(numbers);
    }

    public String extractCustomDelimiter() {
        int delimiterStart = CUSTOM_DELIMITER_PREFIX.length();
        int delimiterEnd = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        String customDelimiter = input.substring(delimiterStart, delimiterEnd);

        int endOfDelimiterSection = delimiterEnd + CUSTOM_DELIMITER_SUFFIX.length();
        input = input.substring(endOfDelimiterSection);

        return customDelimiter;
    }
}
