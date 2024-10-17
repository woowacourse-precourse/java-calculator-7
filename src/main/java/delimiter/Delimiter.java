package delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\\\n(.*)";

    public String[] split(String input) {
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
            if (matcher.find()) {
                String customDelimiter = Pattern.quote(matcher.group(1));
                String numbers = matcher.group(2);
                return numbers.split(customDelimiter);
            } else {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        }
        return input.split(DEFAULT_DELIMITERS);
    }
}
