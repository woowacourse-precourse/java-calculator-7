package calculator.service;

import java.util.Collections;
import java.util.List;

public class DelimiterExtractor {
    
    private static final String PREFIX = "//"; 
    private static final String SUFFIX = "\\n";
    private static final String EMPTY = "";
    
    public List<String> extractDelimiter(String input) {
        if (!input.startsWith(PREFIX)) {
            return Collections.emptyList();
        }
        String firstHalf = getFistHalf(input);
        String[] delimiters = firstHalf.split(EMPTY);
        return List.of(delimiters);
    }

    private String getFistHalf(String input) {
        int indexOfSplitDelimiter = input.indexOf(SUFFIX);
        if (indexOfSplitDelimiter == -1) {
            return EMPTY;
        }
        if (!input.startsWith(PREFIX)) {
            throw new IllegalArgumentException("// 로 시작되어야 합니다.");
        }
        return input.substring(2, indexOfSplitDelimiter);
    }
}
