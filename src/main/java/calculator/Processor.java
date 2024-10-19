package calculator;

import java.util.ArrayList;
import java.util.Arrays;
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

        int[] numbers = convertToIntArray(splitByDelimiters());

        return calculateSum(numbers);
    }

    public String extractCustomDelimiter() {
        int delimiterStart = DELIMITER_DECLARATION_SECTION.length();
        int delimiterEnd = input.indexOf(DELIMITER_AND_NUMBERS_SEPARATOR);
        String customDelimiter = input.substring(delimiterStart, delimiterEnd);

        input = input.substring(delimiterEnd + 1);

        return customDelimiter;
    }

    private String[] splitByDelimiters() {
        String regex = String.join("|", delimiters.stream()
                .map(delimiter -> "\\" + delimiter)
                .toArray(String[]::new));
        return input.split(regex);
    }

    private int[] convertToIntArray(String[] splittedInput) {
        return java.util.Arrays.stream(splittedInput)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private int calculateSum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
