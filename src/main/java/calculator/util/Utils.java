package calculator.util;

public class Utils {
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String REGEX_OPEN_BRACKET = "[";
    private static final String REGEX_CLOSE_BRACKET = "]";
    public static String[] splitStringToArray(String input){
        String customDelimiter = getCustomDelimiterString(input);
        String regex = REGEX_OPEN_BRACKET
                + customDelimiter + DEFAULT_DELIMITERS
                + REGEX_CLOSE_BRACKET;
        String cleanedInput = deleteCustomDelimiterString(input);
        return cleanedInput.split(regex);
    }

    private static String getCustomDelimiterString(String input){
        if(isCustomDelimiterExists(input)){
            int customSplitStringEndIndex = input.indexOf("\\n");
            return input.substring(2, customSplitStringEndIndex);
        }
        return "";
    }

    private static boolean isCustomDelimiterExists(String input){
        return input.startsWith("//") && input.indexOf("\\n") != -1;
    }

    private static String deleteCustomDelimiterString(String input){
        return input.substring(input.indexOf("\\n")+1);
    }
}
