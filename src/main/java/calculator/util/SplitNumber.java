package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static calculator.message.ErrorMessage.*;

public class SplitNumber {
    private static final String CHECK_CUSTOM_DELIMITER = "//(.*)\\\\n(.*)";

    public static List<Integer> checkNumbers(final String input){
        Pattern pattern = Pattern.compile(CHECK_CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            String delimiter = matcher.group(1);
            String postNumber = matcher.group(2);
            validateDelimiter(delimiter);
            return splitNumbers(postNumber, delimiter);
        }
        else{
            return splitNumbers(input);
        }
    }
    private static void validateDelimiter(final String delimiter){
        if (delimiter.length() != 1){
            throw new IllegalArgumentException(INVALID_LENGTH_DELIMITER.getMessage());
        }
    }
    private static List<Integer> splitNumbers(final String input) {
        return Arrays.stream(input.split("[,:]"))
                .map(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(INVALID_WRONG_DELIMITER.getMessage());
                    }
                })
                .collect(Collectors.toList());
    }
    private static List<Integer> splitNumbers(final String input, String delimiter) {
        return Arrays.stream(input.split(Pattern.quote(delimiter)))
                .map(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(INVALID_WRONG_DELIMITER.getMessage());
                    }
                })
                .collect(Collectors.toList());
    }
}
