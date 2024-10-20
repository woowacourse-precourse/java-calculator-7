package calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final List<String> DELIMITERS = Arrays.asList(",", ":");

    public List<String> parseDelimiter(String input) {
        List<String> delimiters = new ArrayList<>(DELIMITERS);

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.*?)\\\\n(.*)", Pattern.DOTALL).matcher(input);
            if (matcher.matches()) {
                String customDelimiter = matcher.group(1);
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
