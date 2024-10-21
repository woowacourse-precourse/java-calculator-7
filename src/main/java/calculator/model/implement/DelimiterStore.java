package calculator.model.implement;

import calculator.model.domain.DefaultDelimiter;
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

    public void addDelimiter(String delimiter) {
        delimiterStore.add(delimiter);
    }

    public Set<String> getAllDelimiters() {
        return new HashSet<>(delimiterStore);
    }

    public void clear() {
        delimiterStore.clear();
        delimiterStore.addAll(DefaultDelimiter.getAll());
    }
}
