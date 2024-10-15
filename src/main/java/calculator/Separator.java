package calculator;

import java.util.List;
import java.util.Optional;

public class Separator {
    private final List<String> defaultSeparators;
    private Optional<String> customSeparator;

    public Separator(List<String> defaultSeparators) {
        this.defaultSeparators = defaultSeparators;
    }

    public void generateCustomSeparators(String customSeparator){
        this.customSeparator = customSeparator.describeConstable();
    }

    public List<String> getDefaultSeparators() {
        return defaultSeparators;
    }
}
