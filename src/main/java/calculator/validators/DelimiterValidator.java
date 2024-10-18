package calculator.validators;

import static calculator.constant.StandardIndex.FIRST_STANDARD;
import static calculator.constant.StandardIndex.SECOND_STANDARD;

public final class DelimiterValidator {

    public static void validateDelimiterFormat(String input) {
        int firstIndex = input.indexOf(FIRST_STANDARD.getStandard());
        int secondIndex = input.indexOf(SECOND_STANDARD.getStandard());
        if (firstIndex > 0) {
            throw new IllegalArgumentException();
        }
        if (firstIndex < 0 && secondIndex >= 0) {
            throw new IllegalArgumentException();
        }
        if (firstIndex == 0 && secondIndex < 0) {
            throw new IllegalArgumentException();
        }
    }
}
