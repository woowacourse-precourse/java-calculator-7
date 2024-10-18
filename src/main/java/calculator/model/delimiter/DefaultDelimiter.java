package calculator.model.delimiter;

public class DefaultDelimiter implements Delimiter {
    private final String delimiter;

    public DefaultDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public boolean isApplicable(String input) {
        return true;
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public boolean isCustomDelimiter() {
        return false;
    }
}
