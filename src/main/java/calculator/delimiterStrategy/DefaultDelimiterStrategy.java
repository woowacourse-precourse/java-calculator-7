package calculator.delimiterStrategy;

import java.util.ArrayList;
import java.util.List;

public class DefaultDelimiterStrategy implements DelimiterStrategy {
    public static final List<String> defaultDelimiters = List.of(",", ":");

    @Override
    public List<String> setUpDelimiter(String userInput) {
        List<String> results = new ArrayList<>();
        results.add(userInput);
        results.addAll(defaultDelimiters);
        return results;
    }
}
