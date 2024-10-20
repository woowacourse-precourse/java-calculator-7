package calculator.util;

import java.util.Arrays;
import java.util.List;

public class DelimiterParser {
    private static final List<String> DELIMITERS = Arrays.asList(",", ":");

    public List<String> parseDelimiter() {

        return DELIMITERS;
    }

    public String[] split(String input, List<String> delimiters) {
        return input.split(String.join("|", delimiters));
    }
}
