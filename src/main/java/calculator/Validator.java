package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public void validate(String input) {
        Matcher match = Pattern
                .compile(Constants.REGEX_INPUT_PATTERN)
                .matcher(input);

        if (!match.matches()) {
            throw new IllegalArgumentException("입력된 값이 유효하지 않음.");
        }
    }
}