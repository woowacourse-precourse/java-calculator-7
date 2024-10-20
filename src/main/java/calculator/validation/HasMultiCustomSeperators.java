package calculator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasMultiCustomSeperators {
    private HasMultiCustomSeperators() {};

    public static void validate(String input, String customSeperator) {
        if(customSeperator.equals("")) {
            return;
        }

        Pattern pattern = Pattern.compile("//(.)(\\\\n).*//");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            throw new IllegalArgumentException();
        }
    }
}
