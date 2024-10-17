package calculator;

import java.util.HashSet;
import java.util.Set;

public class Separators {
    private static final String PIPE = "|";
    private final Set<Separator> seperatorSet;

    public Separators(Set<Separator> seperatorSet) {
        this.seperatorSet = seperatorSet;
    }

    public String toRegexAllowOneOfSeparator() {
        StringBuilder allowOneOfSeparatorRegexBuilder = new StringBuilder();
        seperatorSet.forEach(separator -> {
            putPipeIfNotEmpty(allowOneOfSeparatorRegexBuilder);
            allowOneOfSeparatorRegexBuilder.append(separator.getSeparatorString());
        });
        return allowOneOfSeparatorRegexBuilder.toString();
    }

    private void putPipeIfNotEmpty(StringBuilder builder) {
        if (!builder.isEmpty()) {
            builder.append(PIPE);
        }
    }

    public Separators add(Separator separator) {
        Set<Separator> newSeparatorSet = new HashSet<>(seperatorSet);
        newSeparatorSet.add(separator);
        return new Separators(newSeparatorSet);
    }
}
