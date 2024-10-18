package domain;

import java.util.Arrays;
import java.util.HashSet;

import static constants.Constants.*;

public class Delimiter {

    private static final String REGEX_NUMBER = "[0-9]";
    private static final int OPERATOR_DUPLICATE_VALUE = 2;
    private static final String REGEX_HASHSET_UNNECESSARY = "[\\[\\],]";

    private String delimiters;

    public Delimiter(final String input) {
        delimiters = filterDelimiters(input);
    }

    private String filterDelimiters(final String input) {
        if (input.contains(CUSTOM_START_TEXT)) {
            String delimiters = input.split(REGEX_CUSTOM_END_TEXT)[0].replaceAll(CUSTOM_START_TEXT, EMPTY_TEXT)
                    .replaceAll(REGEX_NUMBER, EMPTY_TEXT);

            if (isDuplicated(delimiters)) {
                return removeDuplication(delimiters);
            }

            return delimiters;
        }

        return input.replaceAll(REGEX_NUMBER, EMPTY_TEXT);
    }

    private Boolean isDuplicated(String value) {
        return Arrays.stream(value.split(EMPTY_TEXT))
                .distinct()
                .count() >= OPERATOR_DUPLICATE_VALUE;
    }

    private String removeDuplication(String values) {
        HashSet<String> set = new HashSet<>();
        for (String value : values.split(EMPTY_TEXT)) {
            set.add(value);
        }

        return set.toString().replace(REGEX_HASHSET_UNNECESSARY, EMPTY_TEXT);
    }

    public String getDelimiters() {
        return delimiters;
    }
}
