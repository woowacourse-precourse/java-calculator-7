package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
    private static final String CUSTOM_START_LETTERS = "//";
    private static final String CUSTOM_END_LETTERS = "\\n";
    private static final String MAKE_SPLIT_FORMAT_LETTER = "|";
    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_COLON = ":";
    private final String input;
    private final List<String> separators;

    public Separator(String input) {
        this.input = input;
        separators = new ArrayList<>();
        handleSeparator();
    }

    public List<String> removeSeparator() {
        return Arrays.stream(removeCustomSeparatorFormat().split(makeSplitFormat())).toList();
    }

    private String removeCustomSeparatorFormat() {
        SeparatorValidator.validateCustomSeparatorFormat(input, CUSTOM_START_LETTERS, CUSTOM_END_LETTERS);
        if (containsCustomSeparator()) {
            return input.substring(input.indexOf(CUSTOM_END_LETTERS) + CUSTOM_END_LETTERS.length());
        }
        return input;
    }

    private void handleSeparator() {
        separators.add(SEPARATOR_COLON);
        separators.add(SEPARATOR_COMMA);
        separators.addAll(extractCustomSeparator());
    }

    private List<String> extractCustomSeparator() {
        List<String> customSeparator = new ArrayList<>();
        if (containsCustomSeparator()) {
            customSeparator.add(input.substring(
                    CUSTOM_START_LETTERS.length(),
                    input.indexOf(CUSTOM_END_LETTERS)));
        }
        return customSeparator;
    }

    private boolean containsCustomSeparator() {
        return input.startsWith(CUSTOM_START_LETTERS) && input.contains(CUSTOM_END_LETTERS);
    }

    private String makeSplitFormat() {
        StringBuilder splitFormat = new StringBuilder();
        for (int i = 0; i < separators.size(); i++) {
            splitFormat.append(separators.get(i));
            if (i < separators.size() - 1) {
                splitFormat.append(MAKE_SPLIT_FORMAT_LETTER);
            }
        }
        return splitFormat.toString();
    }
}
