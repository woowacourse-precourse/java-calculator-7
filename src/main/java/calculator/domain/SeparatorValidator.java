package calculator.domain;

import java.util.List;

public class SeparatorValidator {
    private static final String CUSTOM_START_LETTERS = "//";
    private static final String CUSTOM_END_LETTERS = "\\n";출

    public SeparatorValidator() {
    }

    public static List<String> extractCustomSeparator(List<String> separator, String inputData) {
        if (containsCustomSeparator(inputData)) {
            separator.add(inputData.substring(CUSTOM_START_LETTERS.length(), inputData.indexOf(CUSTOM_END_LETTERS)));
        }
        return separator;
    }

    private static boolean containsCustomSeparator(String inputData) {
        return inputData.startsWith(CUSTOM_START_LETTERS) && inputData.contains(CUSTOM_END_LETTERS);
    }
}
