package calculator.service;

import java.util.List;
import java.util.stream.Collectors;

public class Separators {

    private final List<Separator> separators;

    private Separators(List<Separator> separators) {
        this.separators = separators;
    }

    public static Separators init() {
        List<Separator> defaultSeparators = SeparatorType.getDefaults()
                .stream()
                .map(Separator::create)
                .collect(Collectors.toList());
        return new Separators(defaultSeparators);
    }

    public void add(Separator separator) {
        separators.add(separator);
    }

    public List<String> getValues() {
        return separators.stream()
                .map(Separator::getRegex)
                .toList();
    }
}
