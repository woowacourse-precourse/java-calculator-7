package calculator.delimiterExtractor;

import calculator.constants.StringConst;
import calculator.delimiter.Delimiter;
import calculator.dto.DelimiterDto;
import calculator.utils.ExceptionUtils;
import java.util.regex.Pattern;

public class CustomDelimiterExtractor implements DelimiterExtractor {


    public DelimiterDto extractDelimiter(String input) {

        String[] firstSecondInput = input.split(StringConst.LINE_SEPARATOR_REGEX);
        String firstInput = firstSecondInput[0];
        String delimiterString = firstInput.substring(2);
        isNotNumeric(delimiterString);
        delimiterString = escapeDelimiter(delimiterString);
        Delimiter delimiter = new Delimiter(delimiterString);

        return delimiter.toDto();
    }


    private String escapeDelimiter(String escapeDelimiter) {

        return Pattern.quote(escapeDelimiter);

    }

    private boolean isNotNumeric(String escapeDelimiter) {

        try {
            Long.parseLong(escapeDelimiter);
            ExceptionUtils.throwDelimiterCanNotBeNumberException();
        } catch (NumberFormatException e) {

        }
        return true;

    }
}
