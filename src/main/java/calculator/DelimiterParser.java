package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DelimiterParser {

    private static final String COMMON_DELIMITER = ",";

    public static boolean hasDefaultDelimiters(String input) {
        return input.contains(":") || input.contains(",");
    }

    public List<Integer> parseInputToIntList(String input) {
        String normalizedInput = normalizeDelimiters(input);
        return convertToIntList(normalizedInput);
    }

    private String normalizeDelimiters(String input) {
        if (hasDefaultDelimiters(input)) {
            return input.replaceAll("[,:]", COMMON_DELIMITER);
        }
        String customDelimiter = input.substring(2, input.indexOf("\\n"));
        String numbersPart = input.substring(input.indexOf("\\n") + 2);
        return numbersPart.replaceAll(Pattern.quote(customDelimiter), COMMON_DELIMITER);
    }

    private List<String> splitByCommonDelimiter(String input) {
        return Arrays.stream(input.split(COMMON_DELIMITER)).toList();
    }

    private List<Integer> convertToIntList(String input) {
        return splitByCommonDelimiter(input).stream()
                .map(Validator::validateIfNotNumber)
                .map(Validator::validateIfInputNegative)
                .toList();
    }
}
