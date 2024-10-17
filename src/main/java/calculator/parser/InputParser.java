package calculator.parser;

import calculator.parser.utils.CustomDelimiterParser;
import calculator.parser.utils.Tokenizer;
import calculator.parser.utils.TokensToIntConverter;
import java.util.ArrayList;

public class InputParser {
    private final CustomDelimiterParser customDelimiterParser;
    private final Tokenizer tokenizer;
    private final TokensToIntConverter tokensToIntConverter;

    private InputParser(String defaultDelimiter, String customDelimiterPrefix, String customDelimiterSuffix) {
        this.customDelimiterParser = new CustomDelimiterParser(customDelimiterPrefix, customDelimiterSuffix);
        this.tokenizer = new Tokenizer(defaultDelimiter, customDelimiterPrefix, customDelimiterSuffix);
        this.tokensToIntConverter = new TokensToIntConverter();
    }

    public ArrayList<Integer> parse(String input) {
        Character customDelimiter = customDelimiterParser.getDelimiter(input);
        ArrayList<String> tokens = tokenizer.tokenize(input, customDelimiter);
        return tokensToIntConverter.convertToInt(tokens);
    }

    public static class Builder {
        private String defaultDelimiter;
        private String customDelimiterPrefix;
        private String customDelimiterSuffix;

        public Builder setDefaultDelimiter(String delimiter) {
            this.defaultDelimiter = delimiter;
            return this;
        }

        public Builder setCustomDelimiterFormat(String prefix, String suffix) {
            this.customDelimiterPrefix = prefix;
            this.customDelimiterSuffix = suffix;
            return this;
        }

        public InputParser build() {
            return new InputParser(defaultDelimiter, customDelimiterPrefix, customDelimiterSuffix);
        }
    }
}
