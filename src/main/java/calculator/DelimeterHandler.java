package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimeterHandler {
    private static final String DEFAULT_DELIMITERS = ",:";

    public static List<Character> extractDelimiters(String input) {
        List<Character> delimiterList = new ArrayList<>();

        for (int i = 0; i < DEFAULT_DELIMITERS.length(); i++) {
            delimiterList.add(DEFAULT_DELIMITERS.charAt(i));
        }

        if (hasCustomDelimiter(input) == true) {
            int newlineIdx = input.indexOf("\\n");

            String customDelimiter = input.substring(2, newlineIdx);
            for (int i = 0; i < customDelimiter.length(); i++) {
                char delimiterChar = customDelimiter.charAt(i);

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
