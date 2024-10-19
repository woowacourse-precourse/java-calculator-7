package calculator;

import java.util.regex.Pattern;

public class StringAdder {

    private final InputValidator validator;

    public StringAdder(InputValidator validator) {
        this.validator = validator;
    }

    private int findDelimiterEndIndex(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            return input.indexOf("\\n");
        }
        return -1;
    }

    private String extractDelimiter(String input) {
        String delimiter = ",|:";
        int delimiterEndIndex = findDelimiterEndIndex(input);
        if (delimiterEndIndex != -1) {
            delimiter = input.substring(2, delimiterEndIndex);
            validator.delimiterValidate(delimiter);
        }
        return delimiter;
    }

    private String removeDelimiterSection(String input) {
        int delimiterEndIndex = findDelimiterEndIndex(input);
        if (delimiterEndIndex != -1) {
            return input.substring(delimiterEndIndex + 2);
        }
        return input;
    }

    private String[] splitNumbers(String input, String delimiter) {
        if (delimiter.equals(",|:")) {
            return input.split(delimiter);
        }
        return input.split(Pattern.quote(delimiter));
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = extractDelimiter(input);
        input = removeDelimiterSection(input);

        String[] numbers = splitNumbers(input, delimiter);

        validator.validate(numbers);

        return sumNumbers(numbers);
    }
}
