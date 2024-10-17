package calculator;

public class StringParser {
    private Boolean isCustomDelimiter(String string) {
        String prefix = string.substring(0, 2);
        String suffix = string.substring(3, 5);
        return prefix.equals("//") && suffix.equals("\\n");
    }

    private String getCustomDelimiter(String string) {
        return string.substring(2, 3);
    }

    public String[] parseString(String string) {
        if (string.isEmpty()) {
            return new String[]{"0"};
        }
        if (string.length() >= 5 && isCustomDelimiter(string)) {
            String delimiter = getCustomDelimiter(string);
            String input = string.substring(5);
            if (input.isEmpty()) {
                return new String[]{"0"};
            }
            return input.split(delimiter);
        }
        return string.split("[,|:]");
    }
}
