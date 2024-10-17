package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DelimiterParser {
    private static final String COMMON_DELIMITER = ",";

    private final List<String> delimiterList = new ArrayList<>();

    public DelimiterParser(String... delimiterList) {
        this.delimiterList.addAll(Arrays.asList(delimiterList));
    }

    public static boolean isDefaultDelimiter(String input) {
        return input.contains(":") || input.contains(",");
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
    public List<Integer> parseToIntList(String input) {
        return Arrays.stream(input.split(COMMON_DELIMITER))
                .map(Validator::validateIfNotNumber)
                .collect(Collectors.toList());
    }
}
