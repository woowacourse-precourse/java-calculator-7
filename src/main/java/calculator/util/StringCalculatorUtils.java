package calculator.util;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculatorUtils {

    public static final String BASIC_DELIMITER = "[,:]";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public static boolean isCustom(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    public static int[] findIndex(String custom) {
        int startIndex = custom.indexOf(CUSTOM_DELIMITER_PREFIX);
        int endIndex = custom.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return new int[]{startIndex, endIndex};
    }

    public static String extractDelimiter(String custom, int[] indices) {
        return custom.substring(indices[0] + 2, indices[1]);
    }

    public static String extractStringWithoutDelimiterFormat(String custom, int[] indices) {
        return custom.substring(indices[1] + 2);
    }

    public static String[] parseCustom(String custom, int[] indices) {
        String delimiter = extractDelimiter(custom, indices);
        String extractedString = extractStringWithoutDelimiterFormat(custom, indices);

        return extractedString.split(Pattern.quote(delimiter));
    }

    public static String[] parseBasic(String basic) {
        return basic.split(BASIC_DELIMITER);
    }

    public static int[] convertToIntArray(String[] parsed) {
        return Arrays.stream(parsed)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
