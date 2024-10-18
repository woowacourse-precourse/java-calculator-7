package calculator.domain;

import java.util.Arrays;

public class Separator {
    private final Character value;
    private final static Character[] DEFAULT_SEPARATOR = {',', ':'};

    private Separator(Character value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public static Separator createCustomSeparator(Character value) {
        if (Arrays.asList(DEFAULT_SEPARATOR).contains(value)) {
            throw new IllegalArgumentException();
        }
        return new Separator(value);
    }
}
