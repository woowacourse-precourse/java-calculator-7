package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Integer> list = Arrays.stream(input.split(COMMON_DELIMITER))
                .map(Validator::validateIfNotNumber)
                .toList();
        Validator.validateIfInputNegative(list);
        return list;
    }

    public List<Integer> parseToInt(String input) {
        // input = 1,2:3, 1:2:3, 1,2,3, -1,2:3:, 1,-2,3, 1:2:-3;
        if (isDefaultDelimiter(input)) {
            return splitStringNum(input);
        }
        return parseToIntList(input);
    }

    private List<Integer> splitStringNum(String input) {
        String replaceComma = input.replace("[,:]", ","); // 1,2:3, 1:2:3, 1,2,3, -1,2:3:, 1,-2,3, 1:2:-3
        return parseToInt(replaceComma);
    }
}
