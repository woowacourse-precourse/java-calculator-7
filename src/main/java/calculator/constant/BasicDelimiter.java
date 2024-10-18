package calculator.constant;

import java.util.HashSet;
import java.util.Set;

public class BasicDelimiter {

    public static final String COMMA = ",", COLON = ":";

    public static Set<String> getBasicDelimiters() {
        return Set.of(COMMA, COLON);
    }

    public static Set<String> getCustomDelimiters(String customDelimiter) {
        Set<String> delimiters = new HashSet<>(getBasicDelimiters());
        delimiters.add(customDelimiter);
        return delimiters;
    }
}
