package calculator.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {

    private static final Pattern CUSTOM_REGEX_PATTERN = Pattern.compile("//(.*)\\\\n");
    private static final Set<String> INITIAL_DELIMITER = Set.of(",", ":");

    private final Set<String> delimiters;

    public Delimiters() {
        this.delimiters = new HashSet<>(INITIAL_DELIMITER);
    }

    public Delimiters(String delimiter) {
        this.delimiters = new HashSet<>(Set.of(delimiter));
    }

    public static Delimiters fromInput(String input) {
        Matcher matcher = CUSTOM_REGEX_PATTERN.matcher(input);
        if (matcher.find()) {
            return new Delimiters(matcher.group(1));
        }
        return new Delimiters();
    }

    public String getRegex() {
        return String.join("|", this.delimiters);
    }

    public boolean isCustomDelimiter() {
        return !this.delimiters.equals(INITIAL_DELIMITER);
    }
}
