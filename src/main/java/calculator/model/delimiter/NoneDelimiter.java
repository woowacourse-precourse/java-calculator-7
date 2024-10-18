package calculator.model.delimiter;

import java.util.HashSet;
import java.util.Set;

public class NoneDelimiter implements Delimiter {
    protected static final int DEFAULT_DELIMITER_END = -2;
    private final Set<String> delimiters;
    private final int delimiterEnd;

    public NoneDelimiter() {
        this.delimiters = new HashSet<>();
        this.delimiterEnd = DEFAULT_DELIMITER_END;
    }

    @Override
    public Set<String> getDelimiters() {
        return delimiters;
    }

    @Override
    public int getDelimiterEnd() {
        return delimiterEnd;
    }
}
