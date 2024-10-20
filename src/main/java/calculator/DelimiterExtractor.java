package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimiterExtractor {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public List<String> extractDelimiters(String input) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        if (checkCustomDelimiter(input)) {
            String[] customDelimiters = extractCustomDelimiter(input);
            delimiters.addAll(Arrays.asList(customDelimiters));
        }

        if (delimiters.size() != delimiters.stream().distinct().count()) {
            delimiters = removeDuplicates(delimiters);
        }

        return delimiters;
    }

    private boolean checkCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX)
                && input.contains(CUSTOM_DELIMITER_SUFFIX)
                && input.indexOf(CUSTOM_DELIMITER_SUFFIX) - 2 > 0;
    }

    private String[] extractCustomDelimiter(String input) {
        String customDelimiterStr = input.substring(CUSTOM_DELIMITER_PREFIX.length(),
                input.indexOf(CUSTOM_DELIMITER_SUFFIX));
        String[] customDelimiters = customDelimiterStr.split("");

        return customDelimiters;
    }

    private List<String> removeDuplicates(List<String> delimiters) {
        return delimiters.stream().distinct().toList();
    }
}
