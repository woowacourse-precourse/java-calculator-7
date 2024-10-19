package calculator.delimiter;


public class DelimiterService {
    private DefaultDelimiter defaultDelimiter;
    private CustomDelimiter customDelimiter;

    public DelimiterService() {
        this.defaultDelimiter = new DefaultDelimiter();
        this.customDelimiter = new CustomDelimiter();
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
