package domain;

import java.util.Arrays;
import java.util.HashSet;

public class Delimiter {

    private static final String CUSTOM_START_POINT = "//";
    private static final String CUSTOM_END_POINT = "\\\\n";
    private static final String REGEX_NUMBER = "[0-9]";
    private static final int OPERATOR_DUPLICATE_VALUE = 2;
    private static final String REGEX_HASHSET_UNNECESSARY = "[\\[\\],]";

    private String delimiters;

    public Delimiter(final String input) {
        delimiters = filterDelimiters(input);
    }

    private String filterDelimiters(final String input) {
        if (input.contains(CUSTOM_START_POINT)) {
            String delimiters = input.split(CUSTOM_END_POINT)[0].replaceAll(CUSTOM_START_POINT, "")
                    .replaceAll(REGEX_NUMBER, "");

            if (isDuplicated(delimiters)) {
                return removeDuplication(delimiters);
            }

            return delimiters;
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

        return set.toString().replace(REGEX_HASHSET_UNNECESSARY, "");
    }

    public String getDelimiters() {
        return delimiters;
    }
}
