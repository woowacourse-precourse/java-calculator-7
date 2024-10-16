package calculator;

import java.util.ArrayList;
import java.util.List;

public abstract class DelimiterParser {
    private static final String DEFAULT_REGEX = "[,:]";

    public static boolean isDefaultDelimiter(String input) {
        String[] defaultDelimiterNumber = input.split(DEFAULT_REGEX);
        try {
            Integer.parseInt(defaultDelimiterNumber[0]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<Integer> getNumbersAfterParsing(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char number : input.toCharArray()) {
            numbers.add(Character.getNumericValue(number));
        }
        return numbers;
    }

    public static String splitInputAsString(String input) {
        StringBuilder sb = new StringBuilder();
        String[] split = input.split(DEFAULT_REGEX);
        for (String splitNumber : split) {
            sb.append(splitNumber);
        }
        return sb.toString();
    }
}
