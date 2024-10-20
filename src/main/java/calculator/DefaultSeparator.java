package calculator;

import java.util.Arrays;
import java.util.List;

public enum DefaultSeparator {
    COMMA(','), COLON(':');

    DefaultSeparator(char character) {
        this.character = character;
    }

    private final char character;

    public static List<Character> getSeparators() {
        return Arrays.stream(DefaultSeparator.values())
            .map(sp -> sp.character)
            .toList();
    }

}
