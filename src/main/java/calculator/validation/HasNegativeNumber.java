package calculator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasNegativeNumber {
    private HasNegativeNumber() {};

    public static void validate(String input, String customSeperator) {
        if(customSeperator.equals("-")) {
            return;
        }

        Pattern pattern = Pattern.compile("-\\d+");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            throw new IllegalArgumentException();
        }
    }
}
