package calculator;

public class DefaultDelimiterStrategy implements DelimiterStrategy{
    private static final String DEFAULT_DELIMITER = "[,:]";

    @Override
    public boolean supports(String input) {
        return !input.startsWith("//");
    }

    @Override
    public String[] split(String input) {
        return input.split(DEFAULT_DELIMITER);
    }
}
