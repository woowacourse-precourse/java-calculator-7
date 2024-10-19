package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class SeparatorValidator {
    private static final String CUSTOM_START_LETTERS = "//";
    private static final String CUSTOM_END_LETTERS = "\\n";
    private static final String MAKE_SPLIT_FORMAT_LETTER = "|";
    private static final Pattern VALID_NUMBER_PATTERN = Pattern.compile("[-\\d,:]+");

    public SeparatorValidator() {
    }

    public static List<String> extractCustomSeparator(List<String> separators, String inputData) {
        if (containsCustomSeparator(inputData)) {
            separators.add(inputData.substring(CUSTOM_START_LETTERS.length(), inputData.indexOf(CUSTOM_END_LETTERS)));
        }
        return separators;
    }

    public static List<String> removeSeparator(List<String> separators, String inputData) {
        String str = removeCustomSeparatorFormat(inputData);
        List<String> separatedString = Arrays.asList(separateString(separators, inputData));
    }

    private static boolean containsCustomSeparator(String inputData) {
        return inputData.startsWith(CUSTOM_START_LETTERS) && inputData.contains(CUSTOM_END_LETTERS);
    }

    private static String removeCustomSeparatorFormat(String inputData) {
        return inputData.substring(inputData.indexOf(CUSTOM_END_LETTERS) + CUSTOM_END_LETTERS.length());
    }

    private static String[] separateString(List<String> separators, String inputData) {
        String splitFormat = "";
        for (int i = 0; i < separators.size(); i++) {
            splitFormat += separators.get(i);
            if (i < separators.size() - 1) {
                splitFormat += MAKE_SPLIT_FORMAT_LETTER;
            }
        }
        return inputData.split(splitFormat);
    }
}
