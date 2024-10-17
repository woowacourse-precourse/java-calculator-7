package parser;

public class Delimiter {

    public String extractDelimiter(String input) {
        if (validateStartsWith(input) && validateEndsWith(input)) {
            return String.valueOf(input.charAt(2));
        }
        return null;
    }

    private boolean validateStartsWith(String input) {
        return input.startsWith("//");
    }

    private boolean validateEndsWith(String input) {
        return input.charAt(3) == '\\' && input.charAt(4) == 'n';
    }
}
