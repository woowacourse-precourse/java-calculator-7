package calculator;


public class DelimiterManager {
    private DefaultDelimiter defaultDelimiter;
    private CustomDelimiter customDelimiter;

    public DelimiterManager(DefaultDelimiter defaultSeparator, CustomDelimiter customDelimiter) {
        this.defaultDelimiter = defaultSeparator;
        this.customDelimiter = customDelimiter;
    }

    public String[] generateString(String input) {
        String delimiter = defaultDelimiter.getDefault();
        String custom = customDelimiter.getCustomDelimiter(input);

        if (custom != null) {
            input = customDelimiter.removeCustomPrefix(input);
            delimiter = custom;
        }

        return input.split(delimiter);
    }
}
