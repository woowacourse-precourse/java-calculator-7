package calculator.model;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    private static final String BLANK = "";
    private static final String DEFAULT_SEPARATOR_COMMA = ",";
    private static final String DEFAULT_SEPARATOR_COLON = ":";
    private static final String CUSTOM_SEPARATOR_DEFINITION_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_DEFINITION_SUFFIX = "\n";
    private static List<String> separators = Arrays.asList(DEFAULT_SEPARATOR_COMMA, DEFAULT_SEPARATOR_COLON);

    public boolean isBlank(String input) {
        return input.equals(BLANK);
    }

    public boolean isSeparator(String potentialSeparator) {
        return separators.contains(potentialSeparator);
    }

    public String extractCustomSeparator(String input) {
        int endIndex = findCustomSeparatorEndIndex(input);
        if (endIndex == -1) {
            return null;
        }
        return input.substring(CUSTOM_SEPARATOR_DEFINITION_PREFIX.length(), endIndex);
    }

    public String removeCustomSeparatorDefinition(String input) {
        int endIndex = findCustomSeparatorEndIndex(input);
        if (endIndex == -1) {
            return input;
        }
        return input.substring(endIndex + CUSTOM_SEPARATOR_DEFINITION_SUFFIX.length());
    }

    private int findCustomSeparatorEndIndex(String input) {
        if (!input.startsWith(CUSTOM_SEPARATOR_DEFINITION_PREFIX)) {
            return -1;
        }
        int endIndex = input.indexOf(CUSTOM_SEPARATOR_DEFINITION_SUFFIX);
        if (endIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }
        return endIndex;
    }
}
