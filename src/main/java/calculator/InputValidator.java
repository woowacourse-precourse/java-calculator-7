package calculator;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern numberPattern = Pattern.compile("^[0-9]+([,:][0-9]+)*$");

    public boolean isNull(String input) {
        return input == null || input.isEmpty();
    }

    public boolean isInvalidFormat(String input) {
        return !numberPattern.matcher(input).matches();
    }

    public boolean isCustomDelimExists(String input) {
        return input.startsWith("//");
    }

}
