package calculator.domain.letter;

import static calculator.global.constant.Config.INITIAL_SEPARATORS;
import static java.util.Arrays.stream;

import java.util.Set;
import java.util.stream.Collectors;

public class Separators {
    private final Set<Separator> separators;

    public Separators() {
        separators = getInitialSeparators();
    }

    public void addSeparator(String letter) {
        Separator separator = makeSeparator(letter);
        separators.add(separator);
    }

    private Separator makeSeparator(String separator) {
        return new Separator(separator);
    }

    private Set<Separator> getInitialSeparators() {
        return stream(INITIAL_SEPARATORS)
                .map(Separator::new)
                .collect(Collectors.toSet());
    }

    public boolean contains(String separator) {
        Separator compareSeparator = makeSeparator(separator);
        return separators.contains(compareSeparator);
    }

}
