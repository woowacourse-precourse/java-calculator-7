package calculator.parser;

import calculator.parser.util.CustomDelimiterParser;
import calculator.parser.util.Tokenizer;
import calculator.parser.util.TokensToIntConverter;
import java.util.ArrayList;

public class InputParser {
    private final CustomDelimiterParser delimiterParser;
    private final Tokenizer tokenizer;
    private final TokensToIntConverter intConverter;

    public InputParser(String defaultDelimiter, String customDelimiterPrefix, String customDelimiterSuffix) {
        this.delimiterParser = new CustomDelimiterParser(customDelimiterPrefix, customDelimiterSuffix);
        this.tokenizer = new Tokenizer(defaultDelimiter, customDelimiterPrefix, customDelimiterSuffix);
        this.intConverter = new TokensToIntConverter();
    }

    public ArrayList<Integer> parse(String input) {
        Character customDelimiter = delimiterParser.getDelimiter(input);
        ArrayList<String> tokens = tokenizer.tokenize(input, customDelimiter);
        return intConverter.convertToInt(tokens);
    }

}
