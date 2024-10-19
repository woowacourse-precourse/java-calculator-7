package calculator.domain;

import calculator.domain.input.Input;
import calculator.util.InputValidator;
import java.util.Objects;

public class OtherInput extends Input {

    private OtherInput(String text) {
        super(text);
    }

    public static Input from(String text) {
        return new OtherInput(text);
    }

    @Override
    public Long[] createCalculationInputs() {
        InputValidator.validatePositive(
                InputValidator.validateOnlyPlainNumber(text)
        );

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
        if (!(object instanceof OtherInput that)) {
            return false;
        }
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
