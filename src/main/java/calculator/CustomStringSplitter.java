package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomStringSplitter implements StringSplitter{
    
    private static final String CUSTOM_DELIMITER_HEADER = "\\/\\/";
    private static final String CUSTOM_DELIMITER_FOOTER = "\\\n";

    @Override
    public List<String> splitString (String str) {
        String patternRegex = generatePatternRegex();
        Pattern pattern = Pattern.compile(patternRegex);
        Matcher matcher = pattern.matcher(str);

        boolean isFound = matcher.find();
        validateMatcher(isFound, str);

        String customDelimiter = matcher.group(1);
        validateCustomDelimiter(customDelimiter, str);
        String conjoinedDelimiter = DEFAULT_DELIMITER + customDelimiter;

        String numbersAndDelimiter = matcher.group(2);
        List<String> result = splitSubstring(conjoinedDelimiter, numbersAndDelimiter);
        validateContinuousDelimiter(result, str);

        return result;
    }

    private String generatePatternRegex() {
        StringBuilder delimiterBuilder = new StringBuilder();

        delimiterBuilder.append("^")
                .append(CUSTOM_DELIMITER_HEADER)
                .append("(.+)")
                .append(CUSTOM_DELIMITER_FOOTER)
                .append("(.+)");

        return delimiterBuilder.toString();
    }
    
    private void validateMatcher(boolean isFound, String str) {
        boolean notFound = !isFound;
        if (notFound) {
            throw new IllegalArgumentException(str);
        }
    }

    private void validateCustomDelimiter(String customDelimiter, String str) {
        boolean hasInvalidDelimiter = Arrays.stream(customDelimiter.split(""))
                .anyMatch(s -> INVALID_DELIMITER.contains(s));

        if (hasInvalidDelimiter) {
            throw new IllegalArgumentException(str);
        }
    }

    private List<String> splitSubstring(String conjoinedDelimiter, String numbersAndDelimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(numbersAndDelimiter, conjoinedDelimiter);

        List<String> strings = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            strings.add(stringTokenizer.nextToken());
        }
        return strings;
    }
    
    private void validateContinuousDelimiter(List<String> split, String str) {
        boolean hasContinuousDelimiter = split.stream()
                .anyMatch(s -> s.isEmpty());

        if (hasContinuousDelimiter) {
            throw new IllegalArgumentException(str);
        }
    }
}
