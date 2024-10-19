package Delimiter;

public class DelimiterHandler {
    public static String detectDelimiterType(String input) {
        if (input.startsWith("//")) {
            return "Custom";
        }
        return "Basic";
    }
}
