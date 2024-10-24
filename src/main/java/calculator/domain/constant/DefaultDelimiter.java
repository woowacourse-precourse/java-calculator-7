package calculator.domain.constant;

import java.util.List;
import java.util.stream.Stream;

public enum DefaultDelimiter {
    COMMA,
    COLON;

    public String getDelimiter() {
        return switch (this) {
            case COMMA -> ",";
            case COLON -> ":";
        };
    }

    public static List<String> getDefaultDelimiters() {
        return Stream.of(values())
                .map(DefaultDelimiter::getDelimiter)
                .toList();
    }
}
