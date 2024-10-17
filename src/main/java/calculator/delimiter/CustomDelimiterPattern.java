package calculator.delimiter;

import java.util.regex.Pattern;

public class CustomDelimiterPattern implements DelimiterPattern {
    private static final String REGEX = "^//(\\D)\\\\n\\d*(\\1\\d+)*$";

    @Override
    public boolean validate(String input) {
        return Pattern.matches(REGEX, input);
    }
}
