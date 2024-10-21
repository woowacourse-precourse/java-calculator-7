package calculator.utils;

import java.util.regex.Pattern;

public class Delimiter {
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
}
