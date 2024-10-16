package calculator.service;

import java.util.List;

public class DelimiterExtractor {
    
    private static final String PREFIX = "//"; 
    private static final String SUFFIX = "\\n";
    private static final String EMPTY = "";
    
    public List<String> extractDelimiter(String input) {
        String[] split = input.split(SUFFIX);
        String firstHalf = split[0].replaceAll(PREFIX, EMPTY);
        String[] delimiters = firstHalf.split(EMPTY);
        return List.of(delimiters);
    }
}
