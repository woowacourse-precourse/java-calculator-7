package calculator.util.pattern;

import java.util.List;
import java.util.regex.Pattern;

public class PatternUtils {

    public final static Pattern NUMBER_PATTERNS = Pattern.compile("[0-9]");
    public final static String SPLIT_DELIMITER = "|";

    public static String join(String delimiter, List<String> values) {
        return String.join(delimiter, values);
    }

    public static boolean matchesWithDelimitersIgnoringNumbers(String value, Pattern delimiterPattern) {
        String combinedPattern = String.format("[%s]", NUMBER_PATTERNS + delimiterPattern.pattern());
        return value.matches(combinedPattern + "*");
    }
}
