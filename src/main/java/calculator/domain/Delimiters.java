package calculator.domain;

import static calculator.domain.Expression.CUSTOM_DELIMITER_PREFIX;
import static calculator.domain.Expression.CUSTOM_DELIMITER_SUFFIX;

import java.util.Set;

public class Delimiters {


    private final Set<String> delimiters;

    private Delimiters() {
        this(Set.of());
    }

    private Delimiters(final Set<String> delimiters) {
        this.delimiters = delimiters;
    }

    public static Delimiters of() {
        return new Delimiters();
    }

    public static Delimiters of(final Set<String> delimiters) {
        return new Delimiters(delimiters);
    }

    public static void check(final Delimiters delimiters) {
        for (String delimiter : delimiters.toSet()) {
            if (isNumeric(delimiter)) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자로만 이루어져서는 안됩니다: " + delimiter);
            }

            if (delimiter.isBlank() || delimiter.contains(CUSTOM_DELIMITER_PREFIX)
                    || delimiter.contains(CUSTOM_DELIMITER_SUFFIX)) {
                throw new IllegalArgumentException("올바르지 않은 커스텀 구분자입니다: " + delimiter);
            }
        }
    }

    private static boolean isNumeric(final String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public Set<String> toSet() {
        return Set.copyOf(delimiters);
    }

}
