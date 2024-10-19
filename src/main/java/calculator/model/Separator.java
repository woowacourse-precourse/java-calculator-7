package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Separator {

    private static final String DEFAULT_SEPARATOR_COMMA = ",";
    private static final String DEFAULT_SEPARATOR_COLON = ":";
    private static final String CUSTOM_SEPARATOR_DEFINITION_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_DEFINITION_SUFFIX = "\\n";
    private List<String> separators = Arrays.asList(DEFAULT_SEPARATOR_COMMA, DEFAULT_SEPARATOR_COLON);

    public String[] splitByAllSeparators(String input) {
        String s = extractCustomSeparator(input);
        addCustomSeparator(s);

        String s1 = removeCustomSeparatorDefinition(input);

        String regex = createSeparatorRegex(separators);
        return s1.split(regex);
    }

    private String extractCustomSeparator(String input) {
        int endIndex = findCustomSeparatorEndIndex(input);
        if (endIndex == -1) {
            return null;
        }
        return input.substring(CUSTOM_SEPARATOR_DEFINITION_PREFIX.length(), endIndex);
    }

    private String removeCustomSeparatorDefinition(String input) {
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

    private void addCustomSeparator(String customSeparator) {
        if (customSeparator != null) {
            separators.add(customSeparator);
        }
    }

    private String createSeparatorRegex(List<String> allSeparators) {
        String separatorPattern = allSeparators.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
        return "(" + separatorPattern + ")";
    }
}
