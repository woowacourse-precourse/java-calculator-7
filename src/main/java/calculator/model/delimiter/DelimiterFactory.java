package calculator.model.delimiter;

public class DelimiterFactory {
    public static String getDelimiters(String input) {
        if (input.matches("^//.?\\\\n.*")) {
            return new CustomDelimiter().getDelimiter(input);
        } else {
            return new DefaultDelimiter().getDelimiter(input);
        }
    }
}