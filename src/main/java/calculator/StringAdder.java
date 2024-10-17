package calculator;

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
            int delimiterEndIndex = input.indexOf("\n");
            return input.substring(2, delimiterEndIndex);
        }
        return defaultDelimiter;
    }

    private String removeDelimiterSection(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("/n");
            return input.substring(delimiterEndIndex + 1);
        }
        return input;
    }
}
