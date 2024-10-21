package calculator.util;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PatternFactory {
    public static String buildDelimiterOrPattern(List<String> delimiters){
        return delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
