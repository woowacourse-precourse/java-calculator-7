package calculator.model;

public class Delimiter {
    private final DelimiterStrategy delimiterStrategy;

    public Delimiter(String input) {
        if (input.startsWith("//")) {
            this.delimiterStrategy = new CustomDelimiterStrategy();
        } else {
            this.delimiterStrategy = new DefaultDelimiterStrategy();
        }
    }


}

