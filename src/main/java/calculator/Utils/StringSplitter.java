package calculator.Utils;

import static calculator.Constants.DelimiterConstants.CUSTOM_DELIMITER_END;
import static calculator.Constants.DelimiterConstants.CUSTOM_DELIMITER_START;

import calculator.Model.Delimiter;
import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public static List<String> splitByDelimiter(String userInput, Delimiter delimiter) {
        String[] splitedInput = userInput.split(delimiter.getDelimiter());
        return Arrays.stream(splitedInput).toList();
    }

    public static String getCustomDelimiter(String userInput) {
        return userInput.substring(userInput.indexOf(CUSTOM_DELIMITER_START), userInput.indexOf(CUSTOM_DELIMITER_END));
    }
}
