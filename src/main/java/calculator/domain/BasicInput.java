package calculator.domain;

import calculator.constants.Constants;
import java.util.Arrays;
import java.util.Objects;

public class BasicInput extends Input {

    private final String text;

    private BasicInput(String text) {
        this.text = text;
    }

    public static Input from(String text) {
        return new BasicInput(text);
    }

    @Override
    public Long[] createCalculationInputs() {
        return Arrays.stream(createStrings(text))
                .map(Long::valueOf)
                .toArray(Long[]::new);
    }

    private String[] createStrings(String text) {
        return text.split(Constants.BASIC_DELIMITER);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof BasicInput that)) {
            return false;
        }
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

}
