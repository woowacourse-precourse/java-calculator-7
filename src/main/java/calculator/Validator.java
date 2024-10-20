package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public void validate(String input) {
        Pattern pattern = Pattern.compile(Constants.REGEX_INPUT_PATTERN);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 입력 :)");
        }
    }
}