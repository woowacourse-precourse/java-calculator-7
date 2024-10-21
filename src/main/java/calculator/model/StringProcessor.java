package calculator.model;

import calculator.model.vo.Number;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringProcessor {

    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private List<String> delimiters;

    public StringProcessor() {
        this.delimiters = new ArrayList<>();
    }

    public List<Number> interpret(String expression) {
        if (isCustomDelimiterExist(expression)) {
            createCustomDelimiter(expression);
            String removed = removeAffix(expression);
            return Arrays.stream(removed.split(concatDelimiters()))
                    .map(Number::of)
                    .toList();
        }
        delimiters = List.of(COLON, COMMA);
        return Arrays.stream(expression.split(concatDelimiters()))
                .map(Number::of)
                .toList();
    }

    private boolean isCustomDelimiterExist(String expression) {
        return expression.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private void createCustomDelimiter(String expression) {
        int end = expression.indexOf(CUSTOM_DELIMITER_SUFFIX);

        delimiters.add(expression.substring(CUSTOM_DELIMITER_PREFIX.length(), end));
    }

    private String removeAffix(String original) {
        int end = original.indexOf(CUSTOM_DELIMITER_SUFFIX);

        return original.substring(end + CUSTOM_DELIMITER_SUFFIX.length());
    }

    private String concatDelimiters() {
        return String.join("|", delimiters);
    }
}
