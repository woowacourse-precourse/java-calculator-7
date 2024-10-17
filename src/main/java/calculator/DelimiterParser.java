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
        if (!input.contains(":") && !input.contains(",")) {
            return false;
        }
        return true;
    }

    /*public String splitByDelimiter(String input) {
        return replaceDelimiters(input, delimiterList.getFirst(), delimiterList.getLast());
    }*/

    public String replaceDelimiters(String input) {
        String result = input;

        for (String delimiter : delimiterList) {
            if (delimiter.equals(getPrefix())) {
                result = result.replace(getPrefix(), "");
                continue;
            }
            if (delimiter.equals(getSuffix())) {
                result = result.replace(getSuffix(), "");
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
    private String getPrefix() {
        return delimiterList.getFirst();
    }
    private String getSuffix() {
        return delimiterList.getLast();
    }
}
