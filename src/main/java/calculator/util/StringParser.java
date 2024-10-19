package calculator.util;

import java.util.Arrays;

public class StringParser {

    public static final char[] STANDARD_SEPARATOR = {',', ':'};

    public static String[] split(String input) {
        String separator = Arrays.toString(STANDARD_SEPARATOR);

        if (CustomSeparatorParser.hasCustomSeparator(input)) {
            separator += CustomSeparatorParser.getCustomSeparator(input);
            input = input.substring(5);
        }

        return input.split(Arrays.toString(STANDARD_SEPARATOR));
    }
}
