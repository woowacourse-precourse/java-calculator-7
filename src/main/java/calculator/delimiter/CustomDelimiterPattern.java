package calculator.delimiter;

import java.util.regex.Pattern;

public class CustomDelimiterPattern implements DelimiterPattern {
    private static final String REGEX = "^//(\\D)\\\\n([1-9]\\d*|$)(\\1[1-9]\\d*)*$";

    @Override
    public boolean validate(String input) {
        return Pattern.matches(REGEX, input);
    }
}
