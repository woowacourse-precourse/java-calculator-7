package calculator.util;

import java.util.List;
import java.util.regex.Pattern;

public class Constants {

    public static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*?)\\\\n");
    public static final String DELIMITER_START_PATTERN = "//";
    public static final String DELIMITER_END_PATTERN = "\\n";
}
