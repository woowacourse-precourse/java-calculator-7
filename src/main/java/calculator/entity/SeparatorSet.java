package calculator.entity;

import java.util.HashSet;
import java.util.Set;

public class SeparatorSet {

    private final Set<Separator> separators;

    public SeparatorSet() {
        this.separators = new HashSet<>();
    }

    public String toRegexString() {
        return Separator.getAllSeparatorsRegex(separators);
    }

    public void addSeparator(Separator separator) {
        separators.add(separator);
    }

}
