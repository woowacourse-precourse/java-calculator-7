package calculator.domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DelimiterManager {

    private final List<Character> delimiters;

    public DelimiterManager(List<Character> delimiters) {
        this.delimiters = delimiters;
    }

    public Pattern createDelimiterPattern() {
        String regex = delimiters.stream()
                .map(delimiter -> Pattern.quote(delimiter.toString()))
                .collect(Collectors.joining("|"));

        return Pattern.compile(regex);
    }
}