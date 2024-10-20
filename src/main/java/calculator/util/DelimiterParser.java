package calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final List<String> DELIMITERS = Arrays.asList(",", ":");

    public List<String> parseDelimiter(String input) {
        List<String> delimiters = new ArrayList<>(DELIMITERS);

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1) {
                String customDelimiter = input.substring(2, delimiterEndIndex);
                delimiters.add(Pattern.quote(customDelimiter));
            }
        }

        return delimiters;
    }

    public String[] split(String input, List<String> delimiters) {
        if (input.startsWith("//")) {
            int index = input.indexOf("\\n");
            input = input.substring(index + 2);
        }

        return input.split(String.join("|", delimiters));
    }
}
