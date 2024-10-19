package calculator.domain;

import java.util.List;

public class SeparatorValidator {
    private static final String CUSTOM_START_LETTERS = "//";
    private static final String CUSTOM_END_LETTERS = "\\n";

    public SeparatorValidator() {
    }

    public static List<String> extractCustomSeparator(List<String> separators, String inputData) {
        if (containsCustomSeparator(inputData)) {
            separators.add(inputData.substring(CUSTOM_START_LETTERS.length(), inputData.indexOf(CUSTOM_END_LETTERS)));
        }
        return separators;
    }

    public static List<String> removeSeparator(List<String> separators, String inputData) {
    }

    private static boolean containsCustomSeparator(String inputData) {
        return inputData.startsWith(CUSTOM_START_LETTERS) && inputData.contains(CUSTOM_END_LETTERS);
    }

    private static String removeCustomSeparatorFormat(String inputData) {
        return inputData.substring(inputData.indexOf(CUSTOM_END_LETTERS) + CUSTOM_END_LETTERS.length());
    }
}
