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

    @Test
    void 잘못된_커스텀_구분자_선언_시_예외_발생() {
        // given
        String missingPrefix = ";\\n1;2;3";
        String missingSuffix = "//;1;2;3";
        String customDelimiterPrefix = "//";
        String customDelimiterSuffix = "\\n";

        // when
        Throwable missingPrefixException = catchThrowable(() -> {
            Validator.validateDelimiterDeclaration(missingPrefix, customDelimiterPrefix, customDelimiterSuffix);
        });
        Throwable missingSuffixException = catchThrowable(() -> {
            Validator.validateDelimiterDeclaration(missingSuffix, customDelimiterPrefix, customDelimiterSuffix);
        });

        // then
        assertThat(missingPrefixException).isInstanceOf(IllegalArgumentException.class);
        assertThat(missingSuffixException).isInstanceOf(IllegalArgumentException.class);
    }
}
