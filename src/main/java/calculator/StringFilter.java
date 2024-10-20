package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringFilter {
    private final String DEFAULT_DELIMITER = "[,:]";
    private final StringValidator validator = new StringValidator();

    public int[] convertToIntArray(String input){
        String[] splitInput = checkDelimiterType(input);
        validator.validateString(splitInput);
        validator.validateNegativeNumber(splitInput);

        return Arrays.stream(splitInput)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    
    public String[] checkDelimiterType(String input) {
        if (input.contains("//") && input.contains("\\n")) {
            return findCustomDelimiter(input);
        }
        return splitDefaultDelimiter(input);
    }
    
    private String[] splitDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private static String[] findCustomDelimiter(String Input) {
        String replaceString = Input.replace("//", "").replace("\\n", "");
        String customDelimiter = replaceString.substring(0, 1);
        return splitCustomDelimiter(replaceString, customDelimiter);
    }
    
    private static String[] splitCustomDelimiter(String replaceString, String customDelimiter) {
        return replaceString.substring(1).split(Pattern.quote(customDelimiter));
    }
}