package calculator.delimiter;

import java.util.Set;

public class BasicDelimiter {

    public static final String COMMA = ",", COLON = ":";

    public static Set<String> getBasicDelimiters() {
        return Set.of(COMMA, COLON);
    }
}
