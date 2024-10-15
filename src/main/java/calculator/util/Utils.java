package calculator.util;

import java.util.Arrays;

public class Utils {
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String REGEX_OPEN_BRACKET = "[";
    private static final String REGEX_CLOSE_BRACKET = "]";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    public static int[] stringToIntegerList(String[] stringArr){
        return Arrays.stream(stringArr)
                .mapToInt(Integer::parseInt).toArray();
    }

    public static String[] splitStringToArray(String input){
        String customDelimiter = getCustomDelimiterString(input);
        String regex = getSplitRegex(customDelimiter);

        String cleanedInput = deleteCustomDelimiterString(input);
        return Arrays.stream(cleanedInput.split(regex))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
    }

    private static String getSplitRegex(String customDelimiter){
        return REGEX_OPEN_BRACKET
                + customDelimiter + DEFAULT_DELIMITERS
                + REGEX_CLOSE_BRACKET;
    }

    private static String getCustomDelimiterString(String input){
        if(hasCustomDelimiter(input)){
            int customDelimiterEndIndex = findCustomDelimiterEndIndex(input);
            return input.substring(2, customDelimiterEndIndex);
        }
        return "";
    }

    private static boolean hasCustomDelimiter(String input){
        return hasCustomDelimiterStart(input) && hasCustomDelimiterEnd(input);
    }

    private static String deleteCustomDelimiterString(String input){
        return input.substring(input.indexOf(CUSTOM_DELIMITER_END)+2);
    }

    private static int findCustomDelimiterEndIndex(String input){
        return input.indexOf(CUSTOM_DELIMITER_END);
    }

    private static boolean hasCustomDelimiterEnd(String input){
        return findCustomDelimiterEndIndex(input) != -1;
    }

    private static boolean hasCustomDelimiterStart(String input){
        return input.startsWith(CUSTOM_DELIMITER_START);
    }


}
