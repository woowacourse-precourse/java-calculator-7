package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String COMMON_DELIMITER = ",";

    private final List<String> delimiterList = new ArrayList<>();

    public DelimiterParser(String... delimiterList) {
        this.delimiterList.addAll(Arrays.asList(delimiterList));
    }

    public String replace(String input) {
        String result = input;
        for (String delimiter : delimiterList) {
            if (delimiter.equals(input.substring(0, 2))) {
                result = result.replace(input.substring(0, 2), "");
                continue;
            }
            if (delimiter.equals(input.substring(3, 5))) {
                result = result.replace(input.substring(3, 5), "");
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
        String replaceAllCommas = replaceAllCommas(input);
        return parseToIntList(replaceAllCommas);
    }

    private String replaceAllCommas(String input) {
        if (isDefaultDelimiter(input)) {
            return input.replaceAll("[,:]", COMMON_DELIMITER);
        }
        String delimiter = input.substring(2, input.indexOf("\\n"));
        String numbersPart = input.substring(input.indexOf("\\n") + 2);
        return numbersPart.replaceAll(Pattern.quote(delimiter), COMMON_DELIMITER);
    }

    private List<String> splitCommonDelimiter(String input) {
        return Arrays.stream(input.split(COMMON_DELIMITER)).toList();
    }

    private List<Integer> parseToIntList(String input) {
        return splitCommonDelimiter(input).stream()
                .map(Validator::validateIfNotNumber)
                .map(Validator::validateIfInputNegative)
                .toList();
    }
}
