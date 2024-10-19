package calculator.domain;

import java.util.Objects;

public class EmptyInput extends Input {

    private EmptyInput(String text) {
        super(text);
    }

    public static Input from(String text) {
        return new EmptyInput(text);
    }

    @Override
    public Long[] createCalculationInputs() {
        return new Long[]{0L};
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof EmptyInput that)) {
            return false;
        }
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
