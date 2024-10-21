package calculator;

import java.util.regex.Pattern;

public class SeparatorManager {

    static String initSeparator(String input, boolean hasCustomSeparator) {
        String basicSeparators = ",:";
        if (hasCustomSeparator) {
            char customSeparator = input.charAt(2);
            return Pattern.quote(basicSeparators + customSeparator);
        }
        return basicSeparators;
    }
}
