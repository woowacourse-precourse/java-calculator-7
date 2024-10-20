package calculator.validators;

import static calculator.constant.StandardIndex.FIRST_STANDARD;
import static calculator.constant.StandardIndex.SECOND_STANDARD;

public final class DelimiterValidator {

    private static final int INDEX_THRESHOLD = 0;

    public static void validateDelimiterFormat(String input) {
        int firstIndex = input.indexOf(FIRST_STANDARD.getStandard());
        int secondIndex = input.indexOf(SECOND_STANDARD.getStandard());
        if (firstIndex > INDEX_THRESHOLD) {
            throw new IllegalArgumentException();
        }
        if (firstIndex < INDEX_THRESHOLD && secondIndex >= INDEX_THRESHOLD) {
            throw new IllegalArgumentException();
        }
        if (firstIndex == INDEX_THRESHOLD && secondIndex < INDEX_THRESHOLD) {
            throw new IllegalArgumentException();
        }
    }
}
