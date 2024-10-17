package calculator;

import java.util.List;

public class Separator {
    private List<String> separators;

    public Separator(String input) {
        InputPattern inputPattern = InputPattern.match(input);
        this.separators = inputPattern.getSeparators(input);
    }

    public String makeSeparatorsForSplit() {
        return "[" + String.join("", separators) + "]";
    }

}
