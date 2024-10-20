package calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final List<String> DELIMITERS = Arrays.asList(",", ":");

    public List<String> parseDelimiter(String input) {
        input = input.replace("\\n", "\n");

        List<String> delimiters = new ArrayList<>(DELIMITERS);

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.*?)\n(.*)", Pattern.DOTALL).matcher(input);
            if (matcher.matches()) {
                String customDelimiter = matcher.group(1);
                delimiters.add(Pattern.quote(customDelimiter));
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        return delimiters;
    }

    public String[] split(String input, List<String> delimiters) {
        input = input.replace("\\n", "\n");

        if (input.startsWith("//")) {
            int index = input.indexOf('\n');
            if (index != -1) {
                input = input.substring(index + 1);
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        return input.split(String.join("|", delimiters));
    }
}
