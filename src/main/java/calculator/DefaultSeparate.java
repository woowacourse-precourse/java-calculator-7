package calculator;

import java.util.Arrays;
import java.util.List;

public enum DefaultSeparate {
    COMMA(','), COLON(':');

    DefaultSeparate(char character) {
        this.character = character;
    }

    private final char character;

    public static List<Character> getSeparates() {
        return Arrays.stream(DefaultSeparate.values())
            .map(sp -> sp.character)
            .toList();
    }

}
