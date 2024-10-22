package calculator.model;

public class CustomSeparatorHandler {

    private static final String CUSTOM_SEPARATOR_DEFINITION_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_DEFINITION_SUFFIX = "\\n";

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
