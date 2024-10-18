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
        return input.contains(":") || input.contains(",");
    }
    public List<Integer> parseInputToIntList(String input) {
        // input = 1,2:3, 1:2:3, 1,2,3, -1,2:3:, 1,-2,3, 1:2:-3;
        if (isDefaultDelimiter(input)) {
            String replaceAllCommas = replaceAllByDefaultDelimiter(input);
            return parseToIntList(replaceAllCommas);
        }
        return parseToIntList(input);
    }

    private String replaceAllByDefaultDelimiter(String input) {
        return input.replaceAll("[,:]", ",");
    }
    private String[] splitCommonDelimiter(String input) {
        return input.split(COMMON_DELIMITER);
    }

    private List<Integer> parseToIntList(String input) {
        return Arrays.stream(splitCommonDelimiter(input))
                .map(Validator::validateIfNotNumber)
                .map(Validator::validateIfInputNegative)
                .toList();
    }
}
