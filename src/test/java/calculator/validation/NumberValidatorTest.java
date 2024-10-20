package calculator.validation;

import static calculator.global.constant.ExceptionConstants.INVALID_INPUT_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    NumberValidator numberValidator = new NumberValidator();

    @Test
    @DisplayName("숫자들이 양수인지 유효성 검사를 한다.")
    void validateNumbers() {
        // given
        String[] input1 = new String[]{"1", "2", "3"};
        String[] input2 = new String[]{"", "2", "3"};
        String[] input3 = new String[]{"-1", "2", "3"};

        // when, then
        assertThat(catchThrowable(() -> numberValidator.validateNumbers(input1)))
                .isNull();

        assertThatThrownBy(() -> numberValidator.validateNumbers(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT_ERROR);

        assertThatThrownBy(() -> numberValidator.validateNumbers(input3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT_ERROR);
    }
}
