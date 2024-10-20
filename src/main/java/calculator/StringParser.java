package calculator;

public class StringParser {
    private final String input;
    private final String delimiter;

    public StringParser(String input) {
        this.input = input;
        this.delimiter = ",|:";
    }

    public String[] getTokens() {
        if (input.isEmpty()) {
            return new String[]{};
        }
        return input.split(delimiter);
    }
}
