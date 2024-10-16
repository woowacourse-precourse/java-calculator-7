package calculator.controller.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String regex = "^(//([a-zA-Z!@#$%^&*?._=+\\-;~`|/\\\\])\\\\n)?(\\d+(?:(,|:|\\2)\\d+)*)?$";

    public static boolean isValid(String msg) {
        Pattern INPUT_PATTERN = Pattern.compile(regex);
        Matcher matcher = INPUT_PATTERN.matcher(msg);
        return matcher.find();
    }
}
