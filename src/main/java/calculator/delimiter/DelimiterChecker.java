package calculator.delimiter;

public class DelimiterChecker {

    private final String prefix;
    private final String suffix;

    public DelimiterChecker(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public boolean isCustomDelimiter(String userInput) {
        return userInput.startsWith(prefix) && userInput.contains(suffix);
    }

}