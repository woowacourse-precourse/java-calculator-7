package calculator;

public class StringUtil {
    public static String escapeCustomDelimiter(String input) {
        return input.replace("\\n", "\n");
    }
}
