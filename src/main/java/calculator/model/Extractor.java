package calculator.model;

import static calculator.validate.Validator.validateMatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    private static final String CUSTOM_DELIMITER_PATTERN = "//([\\s\\S]*?)\\\\n\\d+";
    private static final String CONTENT_PATTERN = "([0-9][\\s\\S]*$)";
    private final DelimiterManager delimiterManager;

    public Extractor() {
        this.delimiterManager = new DelimiterManager();
    }

    public String[] extractNumber(String input) {
        if (input.isEmpty()) {
            return new String[]{};
        }
        if (input.startsWith("//")) {
            addCustomDelimiter(input);
            String content = extractGroupByPattern(input, CONTENT_PATTERN);
            return content.split(delimiterManager.getDelimiter());
        }
        return input.split(delimiterManager.getDelimiter());
    }

    private void addCustomDelimiter(String input) {
        String customDelimiter = extractGroupByPattern(input, CUSTOM_DELIMITER_PATTERN);
        delimiterManager.addCustomDelimiter(customDelimiter);
    }

    private String extractGroupByPattern(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        validateMatcher(matcher);
        return matcher.group(1);
    }
}
