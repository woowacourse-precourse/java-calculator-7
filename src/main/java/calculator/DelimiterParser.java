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

    public String splitByDelimiter(String input) {
        String prefix = input.substring(0, 2);
        String suffix = input.substring(3, 5);
        return replaceDelimiters(input, prefix, suffix);
    }

    private String replaceDelimiters(String input, String prefix, String suffix) {
        String result = input;

        for (String delimiter : delimiterList) {
            if (delimiter.equals(prefix)) {
                result = result.replace(prefix, "");
                continue;
            }
            if (delimiter.equals(suffix)) {
                result = result.replace(suffix, "");
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
