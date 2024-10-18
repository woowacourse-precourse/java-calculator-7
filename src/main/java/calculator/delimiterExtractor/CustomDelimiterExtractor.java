package calculator.delimiterExtractor;

import calculator.constants.StringConst;
import calculator.delimiter.Delimiter;
import calculator.dto.DelimiterDto;
import java.util.regex.Pattern;

public class CustomDelimiterExtractor implements DelimiterExtractor {


    public DelimiterDto extractDelimiter(String input) {

        String[] firstSecondInput = input.split(StringConst.LINE_SEPARATOR);
        String firstInput = firstSecondInput[0];
        String delimiterString = firstInput.substring(2);
        delimiterString = escapeDelimiter(delimiterString);
        Delimiter delimiter = new Delimiter(delimiterString);

        return delimiter.toDto();
    }


    private String escapeDelimiter(String escapeDelimiter) {

        return Pattern.quote(escapeDelimiter);

    }
}
