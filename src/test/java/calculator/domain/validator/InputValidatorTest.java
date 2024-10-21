package calculator.domain.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void isMinus() {
        assertThat(inputValidator.isNonPositiveNumber("1")).isFalse();
        assertThat(inputValidator.isNonPositiveNumber("-1")).isTrue();
    }

    @Test
    void checkInputEmpty() {
        assertThat(inputValidator.checkInputEmpty("")).isTrue();
        assertThat(inputValidator.checkInputEmpty("1")).isFalse();
    }

    @Test
    void isNumeric() {
        assertThat(inputValidator.isValidNumber("1")).isTrue();
        assertThat(inputValidator.isValidNumber("a")).isFalse();
        assertThat(inputValidator.isValidNumber("\\")).isFalse();
        assertThat(inputValidator.isValidNumber("\n")).isFalse();
    }

}
