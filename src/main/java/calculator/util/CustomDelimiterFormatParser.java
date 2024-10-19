package calculator.util;

import java.util.ArrayList;
import java.util.List;

public final class CustomDelimiterFormatParser {

    private static final String START_FORMAT = "//";
    private static final String END_FORMAT = "\\n";

    public static boolean isCheckedStart(String input) {
        return input.startsWith(START_FORMAT);
    }

    public static boolean isCheckedFormat(String input) {
        return input.startsWith(START_FORMAT) && input.contains(END_FORMAT);
    }

    public static List<String> splitDelimiterSection(String input) {
        List<String> delimiterSections = new ArrayList<>();
        extractCustomDelimiters(input, delimiterSections);

        return delimiterSections;
    }

    private static void extractCustomDelimiters(String input, List<String> delimiterSections) {
        int startIndex = input.indexOf(START_FORMAT);

        while (startIndex != -1) {
            int endIndex = input.indexOf(END_FORMAT, startIndex);

            if (endIndex != -1) {
                delimiterSections.add(input.substring(startIndex + START_FORMAT.length(), endIndex));
                startIndex = input.indexOf(START_FORMAT, endIndex);
            } else {
                break;
            }
        }
    }

    public static String preprocessInput(String input) {
        if (isCheckedFormat(input)) {
            int endIndex = input.lastIndexOf(END_FORMAT);

            if (endIndex != -1) {
                return input.substring(endIndex + 2);
            }
        }
        return input;
    }

}
