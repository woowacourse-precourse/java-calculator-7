package calculator.domain.model.value;

import java.util.Objects;

import static calculator.global.DefaultSeparators.DEFAULT_SEPARATORS;

public final class Separator {

    public final String value;

    public Separator() {
        this("");
    }

    public Separator(final String value) {
        this.value = String.format("[%s]", value + DEFAULT_SEPARATORS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Separator separator = (Separator) o;
        return Objects.equals(value, separator.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
