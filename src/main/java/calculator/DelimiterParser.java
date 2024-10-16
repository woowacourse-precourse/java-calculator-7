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
            numbers.add(Character.getNumericValue(number)); // - -1
        }
        return numbers;
    }

    public static List<Integer> splitInputAsString(String input) {
        String[] split = input.split(DEFAULT_REGEX);

        // 여기서 List<Integer>로 보내야 될거같음
        List<Integer> list = new ArrayList<>();
        for (String splitNumber : split) {
            Validator.validate(splitNumber);
            list.add(Integer.parseInt(splitNumber));
        }
        return list;
    }
}
