package calculator;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum DefaultDelimiter {

    // 이 변수들은 enum 메서드인 values()에 쓰이므로 주의할 것
    COLON(":"),
    COMMA(",");

    private static final String AND = "|";
    private final String delimiter;

    DefaultDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public static String getAllDelimiters() {
        return Stream.of(DefaultDelimiter.values())
                .map(DefaultDelimiter::getDelimiter)
                .collect(Collectors.joining(AND));
    }
}
