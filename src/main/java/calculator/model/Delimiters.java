package calculator.model;

import calculator.util.ExtractionUtil;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiters {
    private final Set<Character> delimiters;

    public Delimiters(Set<Character> delimiters) {
        this.delimiters = delimiters;
    }

    public Set<Character> getDelimiters() {
        return delimiters;
    }

    public static Delimiters from(String rawInput) {
        char[] extracted = ExtractionUtil.extractDelimiter(rawInput);
        Set<Character> delimiters = new HashSet<>();
        delimiters.add(',');
        delimiters.add(':');
        for (char c : extracted) {
            delimiters.add(c);
        }
        if (extracted.length != delimiters.size() - 2) {
            throw new IllegalArgumentException("구분자를 중복해서 지정할 수 없습니다.");
        }
        return new Delimiters(delimiters);
    }

    public String buildSplitRegex() {
        Set<String> stringSet = delimiters.stream()
                .map(String::valueOf)
                .map(Pattern::quote)
                .collect(Collectors.toSet());
        return String.join("|", stringSet);
    }
}
