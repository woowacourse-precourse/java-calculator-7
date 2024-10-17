package calculator.delimiter;

import java.util.regex.Pattern;

public class DefaultDelimiterPattern implements DelimiterPattern {
    private static final String REGEX = "^\\d*([,:]\\d+)*$";

    @Override
    public boolean validate(String input) {
        return Pattern.matches(REGEX, input);
    }
}
