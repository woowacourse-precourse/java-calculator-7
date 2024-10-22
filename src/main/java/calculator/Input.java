package calculator;

import java.util.Objects;

public class Input {

    private final String input;

    public Input(String input) {
        this.input = input;
    }

    public boolean isEmpty() {
        return this.input == null || this.input.isBlank();
    }

    public boolean hasCustomDelimiter() {
        return this.input.startsWith(DelimiterConfig.CUSTOM_DELIMITER_PREFIX);
    }

    public String getInput() {
        return input;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Input input1 = (Input) o;
        return Objects.equals(input, input1.input);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(input);
    }
}
