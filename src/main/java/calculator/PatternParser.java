package calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternParser {

    public static final String CUSTOM_PATTERN = "^//(.*?)\\\\n";
    public static final String RESERVE_PATTERN = "[,:]";

    public String[] splitPattern(String input) {

        if (isCustomPattern(input)) {
            String delimiter = parseCustomPattern(input);
            return input.split(delimiter);
        }

        return input.split(RESERVE_PATTERN);
    }

    private Matcher matcher(String regex, String input) {
        return Pattern.compile(regex).matcher(input);
    }

    public boolean isCustomPattern(String input) {
        Matcher matcher = matcher(CUSTOM_PATTERN, input);
        return matcher.find() && (matcher.start() == 0);
    }

    public boolean isReservePattern(String input) {
        Matcher matcher = matcher(RESERVE_PATTERN, input);

        Set<String> delimiters = new HashSet<>();
        while (matcher.find()) {
            delimiters.add(matcher.group());
        }

        return delimiters.contains(",") || delimiters.contains(":");
    }

    public String parseCustomPattern(String input) {
        Matcher matcher = matcher(CUSTOM_PATTERN, input);

        if (matcher.find()) {
            return matcher.group(1);
        }

        throw new IllegalArgumentException();
    }

    public boolean validatePattern(String input) {
        if (isReservePattern(input) || isCustomPattern(input)) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
