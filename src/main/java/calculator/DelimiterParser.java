package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimiterParser {
    private static final String COMMON_DELIMITER = ",";

    private final List<String> delimiterList = new ArrayList<>();

    public DelimiterParser(String delimiter) {
        delimiterList.add(delimiter);
    }
    public DelimiterParser(String... delimiterList) {
        this.delimiterList.addAll(Arrays.asList(delimiterList));
    }
    public String replace(String input) {
        String result = input;
        for (String delimiter : delimiterList) {
            if (delimiter.equals(input.substring(0,2))) {
                result = result.replace(input.substring(0,2), "");
                continue;
            }
            if (delimiter.equals(input.substring(3,5))) {
                result = result.replace(input.substring(3,5), "");
                continue;
            }
            result = result.replace(delimiter, COMMON_DELIMITER);
        }
        return result;
    }

    public static boolean isDefaultDelimiter(String input) {
        String[] defaultDelimiterNumber = input.split(COMMON_DELIMITER);
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

    public static List<Integer> parseToIntList(String input) {
        String[] split = input.split(COMMON_DELIMITER);

        List<Integer> list = new ArrayList<>();
        for (String splitNumber : split) {
            Validator.validate(splitNumber);
            list.add(Integer.parseInt(splitNumber));
        }
        return list;
    }
}
