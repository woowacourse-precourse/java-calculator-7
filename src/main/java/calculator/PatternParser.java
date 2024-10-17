package calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternParser {

    public static final String CUSTOM_PATTERN = "^//(.*?)\\\\n";
    public static final String RESERVE_PATTERN = "[,:]";

    private Pattern toPattern(String regex) {
        return Pattern.compile(regex);
    }

    private Matcher toMatcher(String regex, String input) {
        return toPattern(regex).matcher(input);
    }

    public boolean isCustomPattern(String input) {
        Matcher matcher = toMatcher(CUSTOM_PATTERN, input);
        return matcher.find() && (matcher.start() == 0);
    }

    public boolean isReservePattern(String input) {
        Matcher matcher = toMatcher(RESERVE_PATTERN, input);

        Set<String> delimiters = new HashSet<>();
        while (matcher.find()) {
            delimiters.add(matcher.group());
        }

        return delimiters.contains(",") || delimiters.contains(":");
    }

    public String parseCustomPattern(String input) {
        Matcher matcher = toMatcher(CUSTOM_PATTERN, input);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    public String[] splitPattern(String input) {

        if (isCustomPattern(input)) {
            String delimiter = parseCustomPattern(input);
            return input.split(delimiter);
        }

        if (isReservePattern(input)) {
            return input.split(RESERVE_PATTERN);
        }

        return new String[0];
    }
}
