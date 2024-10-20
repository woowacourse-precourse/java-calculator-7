package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String PATTERN = "^//(.*?)\\n";

    public List<Operand> split(String text) {
        String delimiters = extractDelimiters(text);
        String expression = removeCustomDelimiter(text);

        return Arrays.stream(expression.split("[" + delimiters + "]"))
                .map(Operand::new)
                .toList();
    }

    private String removeCustomDelimiter(String text) {
        return text.replaceFirst(PATTERN, "");
    }

    private String extractDelimiters(String text) {
        List<String> delimiters = new ArrayList<>(List.of(",", ":"));
        addCustomDelimiter(text, delimiters);

        return String.join("", delimiters);
    }

    private void addCustomDelimiter(String text, List<String> delimiters) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            delimiters.add(matcher.group(1));
        }
    }
}
