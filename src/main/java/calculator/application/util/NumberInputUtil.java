package calculator.application.util;

import java.util.*;

public final class NumberInputUtil {

    private static final String REGEX_OR_OPERATOR = "|";
    private static final String REGEX_NUMBER = "[0-9]";

    private static final String DELIMITER_INPUT_SPLIT = "";


    private NumberInputUtil () {}

    public static boolean hasInvalidSymbol(String input, Set<String> validSeparators) {
        for (String str : input.split(DELIMITER_INPUT_SPLIT)) {
            if (!str.matches(REGEX_NUMBER) && !validSeparators.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static List<Long> extractNumbers(String input, Set<String> separators) {
        List<String> separatorExpressions = new ArrayList<>(separators);

        String regex = String.join(REGEX_OR_OPERATOR, separatorExpressions);
        String[] inputNumbers = input.split(regex);

        return convertToNumbers(inputNumbers);
    }

    private static List<Long> convertToNumbers(String[] numberValues) {
        List<Long> numbers = new ArrayList<>();
        for (String value : numberValues) {
            try {
                long number = Long.parseLong(value);
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return numbers;
    }


}
