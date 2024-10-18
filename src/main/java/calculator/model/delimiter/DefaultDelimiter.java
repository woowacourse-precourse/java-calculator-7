package calculator.model.delimiter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DefaultDelimiter implements Delimiter {
    private static final String[] DEFAULT_DELIMITERS = new String[]{",", ":"};
    private static final int DEFAULT_DELIMITER_END = -2;
    private final Set<String> delimiters;
    private final int delimiterEnd;

    protected DefaultDelimiter() {
        this.delimiters = new HashSet<>(Arrays.asList(DEFAULT_DELIMITERS));
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
