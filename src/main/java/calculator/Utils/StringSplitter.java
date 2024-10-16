package calculator.Utils;

import static calculator.Constants.DelimiterConstants.CUSTOM_DELIMITER_END;
import static calculator.Constants.DelimiterConstants.CUSTOM_INDICATOR_REGEX;

import calculator.Model.Delimiter;
import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public static List<String> splitByDelimiter(String userInput, Delimiter delimiter) {
        String[] splitedInput = userInput.split(delimiter.getDelimiter());
        return Arrays.stream(splitedInput).toList();
    }

    public static String getCustomDelimiter(String userInput) {
        return userInput.substring(2, userInput.indexOf(CUSTOM_DELIMITER_END));
    }

    public static String deleteIndicator(String userInput) {
        return userInput.replaceAll(CUSTOM_INDICATOR_REGEX, "");
    }
}
