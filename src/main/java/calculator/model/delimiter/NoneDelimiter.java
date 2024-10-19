package calculator.model.delimiter;

import java.util.HashSet;
import java.util.Set;

public class NoneDelimiter implements Delimiter {
    private final Set<String> delimiters;

    public NoneDelimiter() {
        this.delimiters = new HashSet<>();
    }

    @Override
    public Set<String> getDelimiters() {
        return delimiters;
    }
}
