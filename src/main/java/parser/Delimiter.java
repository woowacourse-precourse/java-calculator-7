package parser;

public class Delimiter {

    public String extractDelimiter(String input) {
        if (input.startsWith("//") && input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            return String.valueOf(input.charAt(2));
        }
        return null;
    }
}
