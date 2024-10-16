package calculator.service;

import java.util.List;

public class DelimiterExtractor {
    
    private static final String PREFIX = "//"; 
    private static final String SUFFIX = "\\n";
    private static final String EMPTY = "";
    
    public List<String> extractDelimiter(String input) {
        String[] split = getSplitSuffix(input);
        String firstHalf = getSplitPrefix(split[0]);
        String[] delimiters = firstHalf.split(EMPTY);
        return List.of(delimiters);
    }

    private String getSplitPrefix(String split) {
        if (!split.startsWith(PREFIX)) {
            throw new IllegalArgumentException("// 로 시작되어야 합니다.");
        }
        return split.replaceAll(PREFIX, EMPTY);
    }

    private String[] getSplitSuffix(String input) {
        if (!input.contains(SUFFIX)) {
            throw new IllegalArgumentException("\\n 으로 분리되어야 합니다.");
        }
        return input.split(SUFFIX);
    }
}
