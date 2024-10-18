package calculator.domain;

import java.util.List;

public class Separators {
    private final List<Separator> defaultSeparators;
    private final Separator customSeparator;

    public Separators() {
        this.defaultSeparators = Separator.getDefaultSeparators();
        this.customSeparator = null;
    }
}
