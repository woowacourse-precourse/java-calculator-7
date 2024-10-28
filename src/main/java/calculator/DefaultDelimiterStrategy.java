package calculator;

public class DefaultDelimiterStrategy implements DelimiterStrategy {

    private static final String DEFAULT_DELIMITERS = "[,:]";

    @Override
    public String[] splitNumbers(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }

    @Override
    public boolean matches(String input) {
        return !input.startsWith("//");
    }
}
