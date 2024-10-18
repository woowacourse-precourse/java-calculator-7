package calculator.model.delimiter;

public class DelimiterParser {
    public static Delimiter findDelimiter(final String input) {
        if (input.contains("//") || input.contains("\\n")) {
            return new CustomDelimiter(input);
        } else if (input.contains(",") || input.contains(";")) {
            return new DefaultDelimiter();
        }
        return new NoneDelimiter();
    }
}
