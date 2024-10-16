package calculator.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SeparatorSet {

    private final Set<Separator> separators;

    public SeparatorSet() {
        this.separators = new HashSet<>();
    }

    public RegexStr toRegexStr() {
        String regexString = Separator.toSeparatorsRegex(separators);

        return new RegexStr(regexString);
    }

    public void addSeparator(Separator separator) {
        separators.add(separator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Set<Separator> compareSeparators = ((SeparatorSet) o).separators;
        return Objects.equals(separators, compareSeparators);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(separators);
    }
}
