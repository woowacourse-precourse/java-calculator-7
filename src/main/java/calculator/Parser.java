package calculator;

public class Parser {
    private final DelimiterExtractor delimiterExtractor;

    public Parser(DelimiterExtractor delimiterExtractor) {
        this.delimiterExtractor = delimiterExtractor;
    }

    public String[] parse(String input) {
        String delimiter = delimiterExtractor.extractDelimiter(input);
        String numbers = delimiterExtractor.extractNumbers(input);
        return numbers.split(delimiter);
    }
}
