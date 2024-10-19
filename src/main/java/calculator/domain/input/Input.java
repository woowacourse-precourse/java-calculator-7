package calculator.domain.input;

import java.util.Objects;

public abstract class Input {

    protected final String text;

    protected Input(String text) {
        this.text = text;
    }

    public abstract Long[] createCalculationInputs();

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Input that)) {
            return false;
        }
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
