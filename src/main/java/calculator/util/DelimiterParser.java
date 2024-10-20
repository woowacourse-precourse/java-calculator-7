package calculator.util;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String customDelimiterFormat = "^//.*\\\\n";
    private static final Pattern customDelimiterPattern = Pattern.compile("^//(.*)\\\\n");

    public Optional<String> findCustomDelimiter(String input) {
        Matcher matcher = customDelimiterPattern.matcher(input);
        if (matcher.find()) {
            return Optional.ofNullable(matcher.group(1));
        }
        return Optional.empty();
    }

    public String removeCustomDelimiter(String input) {
        return input.replaceAll(customDelimiterFormat, "");
    }
}
