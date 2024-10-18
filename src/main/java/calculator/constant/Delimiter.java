package calculator.constant;

import java.util.regex.Pattern;

public class Delimiter {

    public static final String CUSTOM_DELIMITER_FORMAT = "^//(.)\\\\n";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_FORMAT);
    public static final String COMMA = ",";
    public static final String COLON = ":";

    private Delimiter() {

    }
}
