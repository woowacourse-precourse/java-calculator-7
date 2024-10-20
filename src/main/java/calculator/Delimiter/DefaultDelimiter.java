package calculator.Delimiter;

public class DefaultDelimiter implements Delimiter {

    private static final String DEFAULT_DELIMITERS = "[,;]";

    @Override
    public boolean supports(String input) {
        return !input.startsWith("//");
    }

    @Override
    public String[] splitStringArray(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }
}
