package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputParser {

    private final String COMMON_DELIMITER = ",";
    private final String DEFAULT_DELIMITER_PATTERN = "[,:]";
    private final String CUSTOM_DELIMITER_START_POSITION = "//";
    private final String CUSTOM_DELIMITER_END_POSITION = "\\n";
    private final int CUSTOM_DELIMITER_START_INDEX = 2;
    private final int NEWLINE_OFFSET = 2;
    private final String SINGLE_INPUT = "-?\\d+";

    public List<Integer> parseInputToIntList(String input) {
        if (input.isBlank()) return List.of(0);

        if (isSingleInput(input)) return convertToIntList(input);

        String standardizedInput = replaceDelimiters(input);
        return convertToIntList(standardizedInput);
    }

    private String replaceDelimiters(String input) {
        if (isStartingWithCustom(input)) {
            int delimiterEndIndex = findDelimiterEndIndex(input);
            String customDelimiter = input.substring(
                    CUSTOM_DELIMITER_START_INDEX,
                    delimiterEndIndex
            );
            String numbersPart = input.substring(
                    delimiterEndIndex + NEWLINE_OFFSET
            );
            return replaceAll(numbersPart, customDelimiter);
        }
        return replaceAll(input, DEFAULT_DELIMITER_PATTERN);
    }

    private String replaceAll(String input, String delimiter) {
        if (input.contains(",") || input.contains(":")) {
            return input.replaceAll(delimiter, COMMON_DELIMITER);
        }
        return input.replaceAll(Pattern.quote(delimiter), COMMON_DELIMITER);
    }

    private boolean isSingleInput(String input) {
        return input.matches(SINGLE_INPUT);
    }

    private boolean isStartingWithCustom(String input) {
        return input.startsWith(CUSTOM_DELIMITER_START_POSITION);
    }

    private int findDelimiterEndIndex(String input) {
        return input.indexOf(CUSTOM_DELIMITER_END_POSITION);
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
