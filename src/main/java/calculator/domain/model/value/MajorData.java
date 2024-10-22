package calculator.domain.model.value;

import java.util.Objects;

public final class MajorData {

    public final String value;

    public MajorData(final String value) {
        this.value = value;
    }

    public String[] split(final Separator separator) {
        return value.split(separator.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MajorData majorData = (MajorData) o;
        return Objects.equals(value, majorData.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
