package calculator;

import java.util.regex.Pattern;

public class StringAdder {
    private final ConsoleIO consoleIO;
    private final InputValidator validator;

    public StringAdder(ConsoleIO consoleIO, InputValidator validator) {
        this.consoleIO = consoleIO;
        this.validator = validator;
    }

    private String extractDelimiter(String input) {
        String defaultDelimiter = ",|:";
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            return input.substring(2, delimiterEndIndex);
        }
        return defaultDelimiter;
    }

    private String removeDelimiterSection(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
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


}
