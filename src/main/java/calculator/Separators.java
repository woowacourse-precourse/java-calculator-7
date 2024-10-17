package calculator;

import java.util.HashSet;
import java.util.Set;

public class Separators {
    private static final String PIPE = "|";
    private final Set<Separator> seperatorSet;

    public Separators(Set<Separator> seperatorSet) {
        this.seperatorSet = seperatorSet;
    }

    public String toRegex() {
        StringBuilder regexBuilder = new StringBuilder();
        seperatorSet.iterator().forEachRemaining(separator -> {
            generateSeparatorRegex(regexBuilder);
            regexBuilder.append(separator.getSeparatorString());
        });
        return regexBuilder.toString();
    }

    private void generateSeparatorRegex(StringBuilder regexBuilder) {
        if (!regexBuilder.isEmpty()) {
            regexBuilder.append(PIPE);
        }
    }

    public Separators add(Separator separator) {
        Set<Separator> newSeparatorSet = new HashSet<>(seperatorSet);
        newSeparatorSet.add(separator);
        return new Separators(newSeparatorSet);
    }
}
