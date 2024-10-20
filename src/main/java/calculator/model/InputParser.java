package calculator.model;

public class InputParser {
    private final DelimiterExtractor delimiterExtractor;

    public InputParser() {
        this.delimiterExtractor = new DelimiterExtractor();
    }

    public String[] parse(String input) {
        String delimiters = delimiterExtractor.extractDelimiters(input);
    }
}
