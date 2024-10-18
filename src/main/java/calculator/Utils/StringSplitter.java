package calculator.Utils;

import static calculator.Constants.DelimiterConstants.CUSTOM_DELIMITER_END;
import static calculator.Constants.DelimiterConstants.CUSTOM_DELIMITER_START_INDEX;
import static calculator.Constants.DelimiterConstants.CUSTOM_INDICATOR_REGEX;

import calculator.Model.Delimiter;
import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public final static String BLANK = "";

    public static List<String> splitByDelimiter(String userInput, Delimiter delimiter) {
        String[] splittedInput = userInput.split(delimiter.getDelimiter());
        return Arrays.stream(splittedInput).toList();
    }

    public static String getCustomDelimiter(String userInput) {
        return userInput.substring(CUSTOM_DELIMITER_START_INDEX, userInput.indexOf(CUSTOM_DELIMITER_END));
    }

    public static String deleteIndicator(String userInput) {
        return userInput.replaceAll(CUSTOM_INDICATOR_REGEX, BLANK);
    }
}
