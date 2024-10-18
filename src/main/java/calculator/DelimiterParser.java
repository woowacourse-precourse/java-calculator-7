package calculator;

import java.util.HashSet;
import java.util.Set;

class DelimiterParser {
    private static final Set<Character> DEFAULT_DELIMITERS = Set.of(',', ':');

    public Set<Character> parseDelimiters(String input) {
        Set<Character> delimiterSet = new HashSet<>(DEFAULT_DELIMITERS);
        String customDelimiter = parseCustomDelimiter(input);
        if (customDelimiter != null) {
            delimiterSet.add(customDelimiter.charAt(0));
        }
        return delimiterSet;
    }

    private String parseCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\n");
            if (delimiterEnd != -1) {
                String customDelimiter = input.substring(2, delimiterEnd);
                if (customDelimiter.length() != 1) {
                    throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
                }
                return customDelimiter;
            }
        }
        return null;
    }

    public String removeCustomDelimiterSection(String input) {
        if (input.startsWith("//")) {
            int newLineIndex = input.indexOf("\n");
            if (newLineIndex != -1) {
                return input.substring(newLineIndex + 1);
            }
        }
        return input;
    }
}