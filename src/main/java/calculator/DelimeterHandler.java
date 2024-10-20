package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimeterHandler {
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String CUSTOM_DELIMITERS_START = "//";
    private static final String CUSTOM_DELIMITERS_END = "\\n";

    public static List<Character> extractDelimiters(String input) {
        List<Character> delimiterList = new ArrayList<>();

        for (char delimiter : DEFAULT_DELIMITERS.toCharArray()) {
            delimiterList.add(delimiter);
        }
        if (hasCustomDelimiter(input) == true) {
            int customDelimiterStartIndex = input.indexOf(CUSTOM_DELIMITERS_START) + CUSTOM_DELIMITERS_START.length();
            int customDelimiterEndIndex = input.indexOf(CUSTOM_DELIMITERS_END);

            String customDelimiters = input.substring(customDelimiterStartIndex, customDelimiterEndIndex);
            for (int i = 0; i < customDelimiters.length(); i++) {
                char delimiterChar = customDelimiters.charAt(i);

                if (delimiterList.contains(delimiterChar) == true) {
                    throw new IllegalArgumentException("duplicate delimiter: " + delimiterChar);
                }
                if (delimiterChar == '-' || Character.isDigit(delimiterChar) == true) {
                    throw new IllegalArgumentException("Invalid delimiter: " + delimiterChar);
                }
                delimiterList.add(delimiterChar);
            }
        }
        return delimiterList;
    }

    public static boolean hasCustomDelimiter(String input) {
        if (input.startsWith("//") == true && input.contains("\\n") == true) {
            return true;
        }
        return false;
    }
}
