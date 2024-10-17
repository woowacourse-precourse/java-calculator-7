package parser;

public class Delimiter {

    public String extractDelimiter(String input) {
        if (validateStartsWith(input) && validateEndsWith(input)) {
            return String.valueOf(input.charAt(2));
        }
        return null;
    }

    public boolean validateHasDefaultOrCustomDelimiter(String input, String customDelimiter) {
        if (!input.matches("[0-9,:" + customDelimiter + "]*")) {
            throw new IllegalArgumentException("허용되지 않는 형식입니다.");
        }
        return true;
    }

    private boolean validateStartsWith(String input) {
        return input.startsWith("//");
    }

    private boolean validateEndsWith(String input) {
        return input.charAt(3) == '\\' && input.charAt(4) == 'n';
    }
}
