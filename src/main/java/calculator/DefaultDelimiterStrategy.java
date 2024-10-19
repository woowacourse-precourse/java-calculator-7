package calculator;

public class DefaultDelimiterStrategy implements DelimiterStrategy {

    private final String defaultDelimiters = ",:";

    public DefaultDelimiterStrategy() {
    }

    @Override
    public String[] split(String input) {
        return new String[0];
    }
}
