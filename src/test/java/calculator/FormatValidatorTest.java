package calculator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FormatValidatorTest {
    @ParameterizedTest
    @CsvSource(value = {"-0,1:2^,|:", ",3, 4,^,", "//::\\n5^,|:", "6789;~!@#$%()_+=-`[]{}:'<>?/\"^;"}, delimiter = '^')
    void 문자열에_구분자나_숫자가_아닌_문자가_있으면_예외_발생(String input, String delimiter) {
        assertThatThrownBy(() -> FormatValidator.validateInput(input, delimiter))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {",0:1,::^,|:", "2,3,45:1999996789^,|:", "0$2$3$$^\\$", "0123456789^;"}, delimiter = '^')
    void 문자열이_구분자와_숫자로만_구성되어_있으면_검증_통과(String input, String delimiter) {
        assertThatCode(() -> FormatValidator.validateInput(input, delimiter)).doesNotThrowAnyException();
    }
}