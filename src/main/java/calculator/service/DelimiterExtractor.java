package calculator.service;

import calculator.domain.DelimiterSet;
import java.util.List;

public class DelimiterExtractor {
    
    private static final String PREFIX = "//"; 
    private static final String SUFFIX = "\\n";
    private static final String EMPTY = "";
    
    public DelimiterSet extractDelimiter(String input) {
        DelimiterSet delimiterSet = new DelimiterSet();
        if (!input.startsWith(PREFIX)) {
            return delimiterSet;
        }
        String firstHalf = getFistHalf(input);
        String[] delimiters = firstHalf.split(EMPTY);
        delimiterSet.addAll(List.of(delimiters));
        return delimiterSet;
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
