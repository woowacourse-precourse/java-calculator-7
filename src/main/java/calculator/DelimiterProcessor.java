package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterProcessor {
    private static final String PREFIX = "//";
    private static final String SUFFIX = "\n";
    private static final String PATTERN = PREFIX + "(.*)" + SUFFIX + "(.*)";

    private List<String> delimiters = new ArrayList<>();
    private boolean containsCustomDelimiter = false;

    public DelimiterProcessor(String input) {
        validateInput(input);
        initializeDefaultDelimiters();
        addDelimiterFromInput(input);
    }

    private void validateInput(String input) {
        if (!input.isEmpty() && !input.contains(",") && !input.contains(":") && !input.contains(PREFIX)) {
            throw new IllegalArgumentException("Input must contain a delimiter");
        }
    }

    private void initializeDefaultDelimiters() {
        delimiters.add(",");
        delimiters.add(":");
    }

    public int getDelimiterCount() {
        return delimiters.size();
    }

    public String getDelimiters() {
        return String.join("|", delimiters);
    }

    public void addDelimiterFromInput(String input) {
        Matcher matcher = Pattern.compile(PATTERN).matcher(input);

        if (matcher.find()) {
            validateCustomDelimiter(matcher.group(2));
            String customDelimiter = matcher.group(1);
            validateSingleCharacterDelimiter(customDelimiter);

            delimiters.add(customDelimiter);
            containsCustomDelimiter = true;
        }
    }

    private void validateCustomDelimiter(String input) {
        if (input.contains(PREFIX)) {
            throw new IllegalArgumentException("Multiple custom delimiters are not allowed");
        }
    }

    private void validateSingleCharacterDelimiter(String customDelimiter) {
        if (customDelimiter.length() > 1) {
            throw new IllegalArgumentException("Custom delimiter must be a single character");
        }
    }

    public boolean containsCustomDelimiter() {
        return containsCustomDelimiter;
    }
}