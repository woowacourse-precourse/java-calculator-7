package calculator.domain;

import calculator.utils.Delimiter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final String INVALID_DELIMITER_MSG = "잘못된 커스텀 구분자 형식입니다.";

    public void validateCustomDelimiterPattern(String input) {
        Matcher matcher = Delimiter.CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (input.startsWith("//") && !matcher.matches()) {
            throw new IllegalArgumentException(INVALID_DELIMITER_MSG);
        }
    }

}
