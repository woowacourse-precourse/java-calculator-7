package calculator;

public class DelimiterParser {
    private static final String DEFAULT_DELIMITER = ",|:";

    public String[] parse(String input) {
        String[] split = split(input, DEFAULT_DELIMITER);
        return split;
    }

    private String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }
}
