package calculator.delimiter;

import java.util.regex.Pattern;

public class DefaultDelimiterPattern implements DelimiterPattern {
    private static final String REGEX = "^([1-9]\\d*|$)([,:]([1-9]\\d*))*$";

    @Override
    public boolean validate(String input) {
        return Pattern.matches(REGEX, input);
    }
}
