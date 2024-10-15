package domain;

import java.util.Arrays;
import java.util.HashSet;

public class Separators {

    private static final String CUSTOM_START_POINT = "//";
    private static final String CUSTOM_END_POINT = "\\\\n";
    private static final String REGEX_NUMBER = "[0-9]";
    private static final int OPERATOR_DUPLICATE_VALUE = 1;
    private static final String REGEX_HASHSET_UNNECESSARY = "[\\[\\],]";

    private String separators;

    public Separators(final String input) {
        separators = filterSeparators(input);
    }

    private String filterSeparators(final String input) {
        if (input.contains(CUSTOM_START_POINT)) {
            String separators = input.split(CUSTOM_END_POINT)[0].replaceAll(CUSTOM_START_POINT, "")
                    .replaceAll(REGEX_NUMBER, "");

            if (isDuplicated(separators)) {
                return removeDuplication(separators);
            }

            return separators;
        }

        return input.replaceAll(REGEX_NUMBER, "");
    }

    private Boolean isDuplicated(String value) {
        return Arrays.stream(value.split(""))
                .distinct()
                .count() >= OPERATOR_DUPLICATE_VALUE;
    }

    private String removeDuplication(String values) {
        HashSet<String> set = new HashSet<>();
        for (String value : values.split("")) {
            set.add(value);
        }

        return set.toString().replaceAll(REGEX_HASHSET_UNNECESSARY, "");
    }

    public String getSeparators() {
        return separators;
    }
}
