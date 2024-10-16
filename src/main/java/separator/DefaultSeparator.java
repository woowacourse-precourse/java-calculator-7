package separator;

import java.util.List;

public class DefaultSeparator implements Separator {
    private final List<String> defaultSeparators;

    public DefaultSeparator(List<String> defaultSeparators) {
        this.defaultSeparators = defaultSeparators;
    }

    @Override
    public List<String> getSeparator() {
        return defaultSeparators;
    }
}
