package calculator;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+([.][0-9]+)?$");

    public void isInvalidNumber(String number) {
        if (!NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isCustomPattern(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

}
