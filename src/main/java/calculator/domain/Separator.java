package calculator.domain;

public class Separator {
    private final Character value;

    private Separator(Character value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public static Separator createCustomSeparator(Character value) {
        return new Separator(value);
    }
}
