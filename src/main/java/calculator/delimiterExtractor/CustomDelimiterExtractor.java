package calculator.delimiterExtractor;

import java.util.regex.Pattern;

public class CustomDelimiterExtractor implements DelimiterExtractor {


    public String extractDelimiter(String input) {

        String[] firstSecondInput = input.split("\\\\n");
        String firstInput = firstSecondInput[0];
        String delimiter = firstInput.substring(2);

        delimiter = checkEscape(delimiter);

        return delimiter;
    }


    private String checkEscape(String escapeDelimiter) {

        return Pattern.quote(escapeDelimiter);

    }
}
