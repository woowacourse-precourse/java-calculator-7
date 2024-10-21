package calculator.delimiter;

public class DefaultDelimiter implements Delimiter {
    protected String delimiters = ",|:";

    @Override
    public String getDelimiters() {
        return delimiters;
    }

    @Override
    public String parseDelimiter(String input) {
        return input;
    }
}
