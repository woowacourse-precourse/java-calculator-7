package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public String extractDelimiters(String input) {
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n").matcher(input);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                if (customDelimiter.equals("-")) {
                    return Pattern.quote(customDelimiter) + "|—|" + DEFAULT_DELIMITERS;
                }
                return Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITERS;
            }
        }
        return DEFAULT_DELIMITERS;
    }
}
