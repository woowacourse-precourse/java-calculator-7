package calculator.model;

import java.util.HashSet;
import java.util.Set;

public class DelimiterStore {

    private static final DelimiterStore INSTANCE = new DelimiterStore();

    private final Set<String> delimiterStore = new HashSet<>(DefaultDelimiter.getAll());

    private DelimiterStore() {
    }

    public static DelimiterStore getInstance() {
        return INSTANCE;
    }

    public void addDelimiters(Set<String> delimiters) {
        delimiterStore.addAll(delimiters);
    }

    public boolean containsDelimiter(String delimiter) {
        return delimiterStore.contains(delimiter);
    }
}
