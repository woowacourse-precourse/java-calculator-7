package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    private String delimiters;
    private String numbersString;

    public DelimiterParser(String input) {
        parseInput(input);
    }

    private void parseInput(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.matches()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            this.delimiters = DEFAULT_DELIMITERS + "|" + customDelimiter;
            this.numbersString = matcher.group(2);
        } else {
            this.delimiters = DEFAULT_DELIMITERS;
            this.numbersString = input;
        }
    }

    public String getDelimiters() {
        return delimiters;
    }

    public String getNumbersString() {
        return numbersString;
    }

}
