package calculator;

public class InputValidator {
    private final Delimiter delimiter;
    private final Parser parser;

    public InputValidator(Delimiter delimiter) {
        this.delimiter = delimiter;
        this.parser = new Parser();
    }

    public String validate(String input) {
        if (input.startsWith("//")) {
            input = delimiter.parseDelimiter(input);
        }
        if (input.isEmpty()) {
            return "0";
        }
        InputFormatValidator.validateFormat(input);
        return this.parser.parse(input, delimiter);
    }

}
