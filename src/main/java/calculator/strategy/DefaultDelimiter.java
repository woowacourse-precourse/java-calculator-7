package calculator.strategy;

public class DefaultDelimiter implements Delimiter {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    @Override
    public String[] split(String input) {
        return input.split(DEFAULT_DELIMITER_REGEX);
    }
}
