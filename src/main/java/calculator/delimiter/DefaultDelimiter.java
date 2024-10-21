package calculator.delimiter;

public class DefaultDelimiter implements Delimiter {
    final String delimiters = ",|:";

    @Override
    public String getDelimiters() {
        return delimiters;
    }

    @Override
    public String parseDelimiter(String input) {
        return input;
    }
}
