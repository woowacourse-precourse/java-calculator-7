package calculator.domain.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void isMinus() {
        assertThat(inputValidator.isMinus("1")).isFalse();
        assertThat(inputValidator.isMinus("-1")).isTrue();
    }

    @Test
    void containCustomDelimiter() {
        assertThat(inputValidator.containCustomDelimiter("//;\\n13;21")).isTrue();
        assertThat(inputValidator.containCustomDelimiter("1,2:3")).isFalse();
    }

    @Test
    void checkInputEmpty() {
        assertThat(inputValidator.checkInputEmpty("")).isTrue();
        assertThat(inputValidator.checkInputEmpty("1")).isFalse();
    }

    @Test
    void isNumeric() {
        assertThat(inputValidator.isNumeric("1")).isTrue();
        assertThat(inputValidator.isNumeric("a")).isFalse();
        assertThat(inputValidator.isNumeric("\\")).isFalse();
        assertThat(inputValidator.isNumeric("\n")).isFalse();
    }

}
