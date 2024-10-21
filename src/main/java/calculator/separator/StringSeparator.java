package calculator.separator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {

    private String basicString;

    private final String CUSTOM_DELIMITER_START = "//";
    private final String CUSTOM_DELIMITER_END = "\\\\n";
    private final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(
            "^" + CUSTOM_DELIMITER_START + "(\\D*)" + CUSTOM_DELIMITER_END + ".*");


    public StringSeparator(String basicString) {
        this.basicString = basicString;
    }


    public boolean validCustomDelimiters() {
        return CUSTOM_DELIMITER_PATTERN.matcher(basicString).matches();
    }

    public String extractCustomDelimiters() {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(basicString);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}
