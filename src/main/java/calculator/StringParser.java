package calculator;

public class StringParser {
    public Boolean isCustomDelimiter(String string) {
        String prefix = string.substring(0, 2);
        String suffix = string.substring(3, 5);
        return prefix.equals("//") && suffix.equals("\\n");
    }
}
