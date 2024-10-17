package calculator;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^([0-9]+([.,][0-9]+)?)([,:][0-9]+([.,][0-9]+)*)*$");
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("^//.\\n");

    public void isInvalidFormat(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isCustomPattern(String input) {
        if (!input.contains("//")) {
            throw new IllegalArgumentException();
        }

        return true;
    }

}
