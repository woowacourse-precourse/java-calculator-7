package calculator.utils.extractor;

import java.util.regex.Pattern;

public class DelimiterExtractor {

    public static String extractDelimiter(String input,
                                          boolean hasCustomDelimiter) {
        if (hasCustomDelimiter) {
            String customDelimiter = Pattern.quote(String.valueOf(input.charAt(2)));
            return "[,:" + customDelimiter + "]";
        }
        return "[,:]";
    }
}
