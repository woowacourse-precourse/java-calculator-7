package calculator.model;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DelimiterManager {
    private final Set<String> separators = new HashSet<>(Set.of(":", ","));

    public String removeCustomDelimiterFrom(String input) {
        StringBuilder result = new StringBuilder(input);
        int start = 0;
        while (true) {
            int delimiterStart = result.indexOf("//", start);
            if (delimiterStart == -1) {
                break;
            }
            int delimiterEnd = result.indexOf("\\n", delimiterStart);
            if (delimiterEnd == -1) {
                break;
            }
            String delimiter = result.substring(delimiterStart + 2, delimiterEnd);
            addSeparator(delimiter);
            result.delete(delimiterStart, delimiterEnd + 2);
            start = delimiterStart;
        }
        return result.toString();
    }

    private void addSeparator(String separator) {
        separators.add(separator);
    }

    public String buildRegex() {
        return separators.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
