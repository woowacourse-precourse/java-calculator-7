package calculator.domain.delimiter;

public class CustomDelimiter implements Delimiter{
    private final String delimiter;

    public CustomDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }
}
