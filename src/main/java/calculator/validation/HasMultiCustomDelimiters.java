package calculator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasMultiCustomDelimiters {
    private HasMultiCustomDelimiters() {}

    public static void validate(String input, String customDelimiter) {
        if(customDelimiter.equals("")) {
            return;
        }

        Pattern pattern = Pattern.compile("//(.)(\\\\n).*//");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            throw new IllegalArgumentException();
        }
    }
}
