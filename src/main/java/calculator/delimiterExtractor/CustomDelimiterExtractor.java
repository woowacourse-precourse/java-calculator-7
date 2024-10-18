package calculator.delimiterExtractor;

import calculator.constants.StringConst;
import java.util.regex.Pattern;

public class CustomDelimiterExtractor implements DelimiterExtractor {


    public String extractDelimiter(String input) {

        String[] firstSecondInput = input.split(StringConst.LINE_SEPARATOR);
        String firstInput = firstSecondInput[0];
        String delimiter = firstInput.substring(2);

        delimiter = checkEscape(delimiter);

        return delimiter;
    }


    private String checkEscape(String escapeDelimiter) {

        return Pattern.quote(escapeDelimiter);

    }
}
