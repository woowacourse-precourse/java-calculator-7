package calculator.delimiterExtractor;

import calculator.constants.StringConst;
import calculator.delimiter.Delimiter;
import calculator.dto.DelimiterDto;
import calculator.validator.Validator;
import java.util.regex.Pattern;

public class CustomDelimiterExtractor implements DelimiterExtractor {
    private Validator validator;

    public CustomDelimiterExtractor(Validator validator) {
        this.validator = validator;
    }

    public DelimiterDto extractDelimiter(String input) {

        String[] firstSecondInput = input.split(StringConst.LINE_SEPARATOR_REGEX);
        String firstInput = firstSecondInput[0];
        String delimiterString = firstInput.substring(2);
        validateCustomDelimiter(delimiterString);
        delimiterString = escapeDelimiter(delimiterString);
        Delimiter delimiter = new Delimiter(delimiterString);

        return delimiter.toDto();
    }

    private void validateCustomDelimiter(String delimiterString) {
        validator.isDelimiterNullOrBlank(delimiterString);
        validator.isNotNumeric(delimiterString);
        validator.isDelimiterLengthOne(delimiterString);
        validator.isNotCustomEqualDefault(delimiterString);
    }

    private String escapeDelimiter(String escapeDelimiter) {

        return Pattern.quote(escapeDelimiter);

    }


}
