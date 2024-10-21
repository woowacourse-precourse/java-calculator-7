package calculator.model;

import calculator.constant.DelimiterConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.constant.DelimiterConstants.CUSTOM_DELIMITER_EXTRACTION_REGEX;

public class ValidatorFactory {

    private ValidatorFactory() {}

    public static Validator createValidator(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_EXTRACTION_REGEX).matcher(input);
        if (matcher.matches()) {
            return new CustomValidator(matcher);
        }
        return new DefaultValidator();

    }
}
