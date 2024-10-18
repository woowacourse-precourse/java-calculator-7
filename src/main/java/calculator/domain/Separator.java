package calculator.domain;

import java.util.Arrays;
import java.util.List;

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

    public static List<Separator> getDefaultSeparators() {
        return Arrays.stream(DEFAULT_SEPARATOR).map(Separator::new).toList();
    }
}
