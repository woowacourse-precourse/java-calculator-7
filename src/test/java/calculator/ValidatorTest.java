package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;
import validator.Validator;

public class ValidatorTest {

    @Test
    void 숫자_0이_입력되면_예외_발생() {
        // given
        int zeroValue = 0;

        // when
        Throwable zeroInputException = catchThrowable(() -> {
            Validator.validateIncludeZero(zeroValue);
        });

        // then
        assertThat(zeroInputException).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 허용되지_않은_문자가_입력되면_예외_발생() {
        // given
        String invalidCharacters = "1&2,3";
        String numberWithSpaces = "1 2:3";
        String emptyCustomDelimiter = "";

        // when
        Throwable invalidCharacterException = catchThrowable(() -> {
            Validator.validateAllowedCharacters(invalidCharacters, emptyCustomDelimiter);
        });
        Throwable spaceCharacterException = catchThrowable(() -> {
            Validator.validateAllowedCharacters(numberWithSpaces, emptyCustomDelimiter);
        });

        // then
        assertThat(invalidCharacterException).isInstanceOf(IllegalArgumentException.class);
        assertThat(spaceCharacterException).isInstanceOf(IllegalArgumentException.class);
    }

}
