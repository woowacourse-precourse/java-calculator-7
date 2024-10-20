package calculator.model;

import java.util.List;

public class Parser {
    private final String input;
    private ParsingStrategy parsingStrategy;

    public Parser(final String input) {
        this.input = input;
        setParsingStrategy(input);
    }

    public List<Integer> parse() {
        return parsingStrategy.parse(input);
    }

    private void setParsingStrategy(final String input) {
        if (hasCustomDelimiter()) {
            parsingStrategy = new CustomDelimiterParsingStrategy();
        }
        if (!hasCustomDelimiter()) {
            parsingStrategy = new DefaultDelimiterParsingStrategy();
        }
    }

    private boolean hasCustomDelimiter() {
        return input.startsWith(DelimiterConstant.CUSTOM_VALIDATOR_PREFIX.getValue());
    }
}