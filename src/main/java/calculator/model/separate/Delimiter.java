package calculator.model.separate;

import java.util.List;

public enum Delimiter {
    BASIC(List.of(",", ":")),
    ;

    private final List<String> delimiters;

    Delimiter(List<String> delimiters) {
        this.delimiters = delimiters;
    }

    public static List<String> basic() {
        return BASIC.delimiters;
    }
}
