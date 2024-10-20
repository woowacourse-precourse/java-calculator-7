package calculator.util;

import java.util.Arrays;

public class StringParser {

    public static final char[] STANDARD_SEPARATOR = {',', ':'};

    public static String[] split(String input) {
        StringBuilder separator = new StringBuilder();
        for (char c : STANDARD_SEPARATOR) {
            separator.append(c);
        }

        if (CustomSeparatorParser.hasCustomSeparator(input)) {
            separator.append(CustomSeparatorParser.getCustomSeparator(input));
            input = input.substring(5);
        }

        return input.split("[" + separator.toString() + "]");
    }
}
