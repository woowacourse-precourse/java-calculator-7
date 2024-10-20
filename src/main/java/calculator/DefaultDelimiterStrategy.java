package calculator;

public class DefaultDelimiterStrategy implements DelimiterStrategy {

    private final String[] defaultDelimiters = {",", ":"};

    public DefaultDelimiterStrategy() {

    }

    @Override
    public String[] split(String input) {
        input = DelimiterStrategyUtil.replaceDelimiters(input, defaultDelimiters);
        String[] tokens = input.split(",");
        DelimiterStrategyUtil.validateAndParseNumbers(input, tokens);
        return tokens;
    }
}
