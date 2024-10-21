package calculator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FormatValidatorTest {
    private final FormatValidator formatValidator = new FormatValidator();

    @ParameterizedTest
    @CsvSource(value = {"-0,1:2^,|:", ",3, 4,^,", "//::\\n5^,|:", "6789;~!@#$%()_+=-`[]{}:'<>?/\"^;"}, delimiter = '^')
    void 문자열에_구분자나_숫자가_아닌_문자가_있으면_예외_발생(String input, String delimiter) {
        assertThatThrownBy(() -> formatValidator.validateCharactersOrThrow(input, delimiter))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {",0:1,::^,|:", "2,3,45:1999996789^,|:", "0$2$3$$^\\$", "0123456789^;"}, delimiter = '^')
    void 문자열이_구분자와_숫자로만_구성되어_있으면_검증_통과(String input, String delimiter) {
        assertThatCode(() -> formatValidator.validateCharactersOrThrow(input, delimiter)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({"0,1", "10,01234", ",0123456789"})
    void 숫자를_나타내는_문자열이_0으로_시작하면_예외_발생(String a, String b) {
        assertThatThrownBy(() -> formatValidator.validateNoLeadingZeroOrThrow(Arrays.asList(a, b)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1,20", "30,", ",600", "1234567890,1999999999"})
    void 숫자를_나타내는_문자열이_0으로_시작하지_않으면_검증_통과(String a, String b) {
        assertThatCode(() -> formatValidator.validateNoLeadingZeroOrThrow(Arrays.asList(a, b))).doesNotThrowAnyException();
    }
}