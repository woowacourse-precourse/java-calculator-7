package calculator.model;

import java.util.Set;

public class DelimiterManager {

    private final DelimiterChecker delimiterChecker;
    private final DelimiterExtractor delimiterExtractor;
    private final DelimiterStore delimiterStore;

    public DelimiterManager(DelimiterChecker delimiterChecker, DelimiterExtractor delimiterExtractor,
            DelimiterStore delimiterStore) {
        this.delimiterChecker = delimiterChecker;
        this.delimiterExtractor = delimiterExtractor;
        this.delimiterStore = delimiterStore;
    }

    public void registerCustomDelimiters(String value) {
        if (!delimiterChecker.existCustomDelimiter(value)) {
            return;
        }
        Set<String> customDelimiters = delimiterExtractor.extractCustom(value);
        delimiterStore.addDelimiters(customDelimiters);
    }
}
