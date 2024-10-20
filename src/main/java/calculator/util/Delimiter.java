package calculator.util;

import java.util.regex.Pattern;

public class Delimiter {

    public static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    public static String extractDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\n");

        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException();
        }

        return Pattern.quote(input.substring(2, delimiterEndIndex));
    }

}
