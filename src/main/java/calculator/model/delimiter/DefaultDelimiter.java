package calculator.model.delimiter;

public class DefaultDelimiter implements Delimiter {
    private final String delimiter;

    public DefaultDelimiter(String delimiter) {
        this.delimiter = delimiter;
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
