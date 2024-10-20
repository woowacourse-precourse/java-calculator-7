package calculator.model.delimiter;

public class Delimiter {
    private final DelimiterStrategy delimiterStrategy;

    public Delimiter(String input) {
        if (input.startsWith("//")) {
            this.delimiterStrategy = new CustomDelimiterStrategy();
        } else {
            this.delimiterStrategy = new DefaultDelimiterStrategy();
        }
    }

    public String[] getStringArray(String input) {
        return delimiterStrategy.getStringArray(input);
    }


}

