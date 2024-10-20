package calculator.delimiterStrategy;

import java.util.List;

public class DefaultDelimiterStrategy implements DelimiterStrategy {
    public static final List<String> defaultDelimiters = List.of(",", ":");

    @Override
    public List<String> decideDelimiter(String userInput) {
        return List.of(",", ":");
    }
}
