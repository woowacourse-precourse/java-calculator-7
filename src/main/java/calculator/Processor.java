package calculator;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private static final String DELIMITER_DECLARATION_SECTION = "//";
    private static final String DELIMITER_AND_NUMBERS_SEPARATOR = "\\n";
    private List<String> delimiters = new ArrayList<>(List.of(",", ":"));
    private String input;

    public Processor(String input) {
        this.input = input;
    }

    public int execute() {
        if (input.startsWith(DELIMITER_DECLARATION_SECTION)) {
            String customDelimiter = extractCustomDelimiter();
            delimiters.add(customDelimiter);
        }

        String[] splitInput = Splitter.splitByDelimiters(input, delimiters);
        int[] numbers = Converter.toIntArray(splitInput);

        return Calculator.calculateSum(numbers);
    }

    public String extractCustomDelimiter() {
        int delimiterStart = DELIMITER_DECLARATION_SECTION.length();
        int delimiterEnd = input.indexOf(DELIMITER_AND_NUMBERS_SEPARATOR);
        String customDelimiter = input.substring(delimiterStart, delimiterEnd);

        int endOfDelimiterSection = delimiterEnd + DELIMITER_AND_NUMBERS_SEPARATOR.length();
        input = input.substring(endOfDelimiterSection);

        return customDelimiter;
    }
}
