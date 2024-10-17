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
    public String splitByDelimiter(String input) {
        String result = input;

        final String prefix = input.substring(0,2);
        final String suffix = input.substring(3,5);
        final String space = "";

        for (String delimiter : delimiterList) {
            if (delimiter.equals(prefix)) {
                result = result.replace(prefix, space);
                continue;
            }
            if (delimiter.equals(suffix)) {
                result = result.replace(suffix, space);
                continue;
            }
            result = result.replace(delimiter, COMMON_DELIMITER);
        }
        return result;
    }

    public boolean isDefaultDelimiter(String input) {
        String[] defaultDelimiterNumber = input.split(COMMON_DELIMITER);
        try {
            Integer.parseInt(defaultDelimiterNumber[0]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Integer> parseToIntList(String input) {
        String[] split = input.split(COMMON_DELIMITER);

        List<Integer> list = new ArrayList<>();
        for (String splitNumber : split) {
            list.add(Validator.validateIfNotNumber(splitNumber));
        }
        return list;
    }
}
