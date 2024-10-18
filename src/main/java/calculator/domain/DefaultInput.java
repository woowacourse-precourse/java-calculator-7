package calculator.domain;

import calculator.util.InputValidator;
import java.util.Objects;

public class DefaultInput extends Input {

    private final String text;

    private DefaultInput(String text) {
        this.text = text;
    }

    public static Input from(String text) {
        return new DefaultInput(text);
    }

    @Override
    public Long[] createCalculationInputs() {
        InputValidator.validateHasNumber(text);

        return new Long[]{toLong(text)};
    }

    private Long toLong(String text) {
        return Long.valueOf(text);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DefaultInput that)) {
            return false;
        }
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
