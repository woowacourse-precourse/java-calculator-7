package calculator.calculator;

import calculator.constant.Constant;
import calculator.input.InputValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Pattern customPattern = Pattern.compile("//(.*)\\\\n(.*)");

    public String[] split(String input) {
        Matcher matcher = customPattern.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            InputValidator.validateDelimiterBlank(delimiter);
            return matcher.group(2).split(Pattern.quote(delimiter));
        }

        return input.split(Constant.ORIGIN_DELIMITER_REGEX);
    }
}
