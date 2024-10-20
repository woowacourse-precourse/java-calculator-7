package calculator.model.delimiter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DefaultDelimiter implements Delimiter {
    protected static final String[] DEFAULT_DELIMITERS = new String[]{",", ":"};
    private final Set<String> delimiters;

    protected DefaultDelimiter() {
        this.delimiters = new HashSet<>(Arrays.asList(DEFAULT_DELIMITERS));
    }

    @Override
    public Set<String> getDelimiters() {
        return delimiters;
    }
}
