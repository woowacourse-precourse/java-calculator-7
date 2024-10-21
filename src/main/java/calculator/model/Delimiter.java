package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private List<String> delimiters = new ArrayList<>();

    public void choose(String expression) {
        if (isCustomDelimiterExist(expression)) {
            createCustomDelimiter(expression);
        } else {
            delimiters = List.of(COLON, COMMA);
        }
    }

    private boolean isCustomDelimiterExist(String expression) {
        return expression.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private void createCustomDelimiter(String expression) {
        int end = expression.indexOf(CUSTOM_DELIMITER_SUFFIX);
        delimiters.add(expression.substring(CUSTOM_DELIMITER_PREFIX.length(), end));
    }
}
