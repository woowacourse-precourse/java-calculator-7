package calculator.delimiter;

public class DelimiterFactory {
    public static Delimiter createDelimiter(String input) {
        if (input.startsWith("//")) {
            return new CustomDelimiter();
        }
        return new DefaultDelimiter();
    }
}
