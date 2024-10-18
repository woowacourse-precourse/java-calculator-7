package calculator.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final String DEFAULT_DELIMITER = ",:";

    public String extractDelimiter(String input) {
        String delimeter = DEFAULT_DELIMITER;

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*?)").matcher(input);
            if (matcher.find()) {
                delimeter = delimeter + matcher.group(1);
            }
        }

        return "[" + delimeter + "]";
    }

    public List<String> parseStringToList(String input, String delimiter) {
        if (input.startsWith("//")) {
            input = input.split("\\\\n", 2)[1];
        }

        String[] elements = input.split(delimiter);

        List<String> result = new ArrayList<>();
        Collections.addAll(result, elements);

        return result;
    }
}
