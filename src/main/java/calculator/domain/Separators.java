package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Separators {
    private final List<Separator> defaultSeparators;
    private final Separator customSeparator;

    public Separators() {
        this.defaultSeparators = Separator.getDefaultSeparators();
        this.customSeparator = null;
    }

    public Separators(Separator customSeparator) {
        this.defaultSeparators = Separator.getDefaultSeparators();
        this.customSeparator = customSeparator;
    }

    public boolean contains(Character character) {
        return getSeparators().stream().map(Separator::getValue)
                .anyMatch(separatorCharacter -> separatorCharacter == character);
    }

    public List<Separator> getSeparators() {
        ArrayList<Separator> allSeparators = new ArrayList<>(defaultSeparators);

        if (customSeparator != null) {
            allSeparators.add(customSeparator);
        }

        return allSeparators;
    }
}
