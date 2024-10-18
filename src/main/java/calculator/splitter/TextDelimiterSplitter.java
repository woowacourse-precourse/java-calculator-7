package calculator.splitter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class TextDelimiterSplitter {

    public List<String> split(String text, Set<String> delimiters) {
        return Arrays.stream(text.split(getDelimiterRegex(delimiters))).toList();
    }

    private String getDelimiterRegex(Set<String> delimiters) {
        return delimiters.stream()
                .map(Pattern::quote)
                .collect(joining("", "[", "]"));
    }
}
