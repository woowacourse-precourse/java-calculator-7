package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class DelimiterChecker {

    private static List<Character> DELIMITERS = List.of(',', ':');
    private static final String CUSTOM_DELIMITER_BEGIN = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    private static final int CUSTOM_DELIMITER_INDEX = 2;

    public static List<Integer> checkDelimiter(String input) {
        if (isCustomed(input)) addDelimiter(input);

        return leaveOnlyNumbers(input);
    }

    public static boolean isCustomed(String input) {
        return input.startsWith(CUSTOM_DELIMITER_BEGIN) &&
                input.contains(CUSTOM_DELIMITER_END);
    }

    public static void addDelimiter(String input) {
        DELIMITERS.add(input.charAt(CUSTOM_DELIMITER_INDEX));
    }

    public static List<Integer> leaveOnlyNumbers(String input) {
        int endIndex = input.indexOf(CUSTOM_DELIMITER_END);
        List<Integer> numbers = new ArrayList<>();
        String number = "";
        for (int current = endIndex + 2; current < input.length(); current++) {
            char currentChar = input.charAt(current);

            if (Character.isDigit(currentChar)) number += currentChar;
            else if (isRightDelimiter(currentChar)) {
                numbers.add(Integer.parseInt(number));
                number = "";
            }
        }
        return numbers;
    }

    public static boolean isRightDelimiter(char currentChar) {
        if (DELIMITERS.contains(currentChar)) return true;
        else throw new IllegalArgumentException();
    }
}
