package calculator.model;

import java.util.List;

public class Parser {
    private final Delimiters delimiters;
    private final String input;
    private ParsingStrategy parsingStrategy;

    public Parser(final String input) {
        this.input = input;
        this.delimiters = new Delimiters();
        setParsingStrategy(input);
    }

    public List<Integer> parse() {
        return parsingStrategy.parse(input);
    }

    private void setParsingStrategy(final String input) {
        if (delimiters.hasCustomDelimiter(input)) {
            parsingStrategy = new CustomDelimiterParsingStrategy(delimiters);
        }
        if (!delimiters.hasCustomDelimiter(input)) {
            parsingStrategy = new DefaultDelimiterParsingStrategy(delimiters);
        }
    }
}
