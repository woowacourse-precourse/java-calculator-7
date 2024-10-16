package calculator;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterManager {
    public static final String CUSTOM_DELIMITER_PATTERN = "^//.+\\\\n";
    public static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public Optional<String> findCustomSeparator(String input) {
        Matcher matcher = PATTERN.matcher(input);

        if (!matcher.find()) {
            return Optional.empty();
        }

        int matchStart = matcher.start();
        int matchEnd = matcher.end();

        return Optional.of(input.substring(matchStart + 2, matchEnd - 2));
    }
}
