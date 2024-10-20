package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputParser {

    private final String COMMON_DELIMITER = ",";
    private final String DEFAULT_DELIMITER_PATTERN = "[,:]";
    private final String CUSTOM_DELIMITER_NEWLINE = "\\n";
    private final int CUSTOM_DELIMITER_START_INDEX = 2;
    private final int NEWLINE_OFFSET = 2;

    public boolean hasDefaultDelimiters(String input) {
        return input.contains(":") || input.contains(",");
    }

    public List<Integer> parseInputToIntList(String input) {
        String standardizedInput = replaceDelimiters(input);
        return convertToIntList(standardizedInput);
    }

    private String replaceDelimiters(String input) {
        if (hasDefaultDelimiters(input)) {
            return input.replaceAll(DEFAULT_DELIMITER_PATTERN, COMMON_DELIMITER);
        }
        String customDelimiter = input.substring(CUSTOM_DELIMITER_START_INDEX, findDelimiterEndIndex(input));
        String numbersPart = input.substring(findDelimiterEndIndex(input) + NEWLINE_OFFSET);
        return numbersPart.replaceAll(Pattern.quote(customDelimiter), COMMON_DELIMITER);
    }

    private int findDelimiterEndIndex(String input) {
        return input.indexOf(CUSTOM_DELIMITER_NEWLINE);
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
