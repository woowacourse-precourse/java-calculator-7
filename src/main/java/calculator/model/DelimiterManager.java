package calculator.model;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DelimiterManager {
    private final Set<String> separators = new HashSet<>(Set.of(":", ","));

    private void addSeparator(String separator) {
        separators.add(separator);
    }

    public String buildRegex() {
        return separators.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }

    public String removeCustomDelimiterFrom(String input) {
        int start = 0;
        int idx = 0;
        while (idx < input.length()) {
            if (input.charAt(idx) == '/') {
                start = idx;
            }
            if (input.charAt(idx) == '\\') {
                String separator = input.substring(start + 1, idx);
                addSeparator(separator);
                input = input.substring(0, start - 1) + input.substring(idx + 2);
                idx = -1;
            }
            idx++;
        }
        return input;
    }
}
