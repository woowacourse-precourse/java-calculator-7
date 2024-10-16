package calculator.model.separate;

import java.util.List;

public enum Delimiter {
    BASIC(List.of(",", ":")),
    CUSTOM_CHECKER(List.of("//", "\n")),
    OR(List.of("|"))
    ;

    private final List<String> delimiters;

    Delimiter(List<String> delimiters) {
        this.delimiters = delimiters;
    }

    public static List<String> basic() {
        return BASIC.delimiters;
    }

    public static List<String> customChecker() {
        return CUSTOM_CHECKER.delimiters;
    }

    public static String or() {
        return OR.delimiters.getFirst();
    }
}
