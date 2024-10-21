package calculator.separator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {

    private String basicString;
    private String delimiters;

    private final String BASIC_DELIMITERS = ":,";
    private final String CUSTOM_DELIMITER_START = "//";
    private final String CUSTOM_DELIMITER_END = "\\\\n";
    private final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(
            "^" + CUSTOM_DELIMITER_START + "(\\D*)" + CUSTOM_DELIMITER_END + ".*");


    public StringSeparator(String basicString) {
        this.basicString = basicString;
        this.delimiters = BASIC_DELIMITERS;
    }

    public StringSeparator() {
        this.delimiters = BASIC_DELIMITERS;
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

    public String addCustomDelimiters(String customDelimiters) {
        return delimiters += customDelimiters;
    }

    public String splitCustomDelimiters() {
        return basicString = basicString.split(CUSTOM_DELIMITER_END)[1];
    }
}
