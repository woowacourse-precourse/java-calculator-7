package calculator.delimiter;

import java.util.regex.Pattern;

public class CustomDelimiterPattern implements DelimiterPattern {
    private static final String REGEX = "^//(\\D)\\\\n(([1-9]\\d{0,2}|1000)|$)(\\1([1-9]\\d{0,2}|1000)){0,49}$";

    @Override
    public boolean validate(String input) {
        return Pattern.matches(REGEX, input);
    }
}
