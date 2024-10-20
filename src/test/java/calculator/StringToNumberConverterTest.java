package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringToNumberConverterTest {
    @ParameterizedTest
    @CsvSource({"0,1", "10,01234", ",0123456789"})
    void 숫자를_나타내는_문자열이_0으로_시작하면_예외_발생(String a, String b) {
        assertThatThrownBy(() -> new StringToNumberConverter(Arrays.asList(a, b)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1,20", "30,", ",600", "1234567890,1999999999"})
    void 숫자를_나타내는_문자열이_0으로_시작하지_않으면_검증_통과(String a, String b) {
        assertThatCode(() -> new StringToNumberConverter(Arrays.asList(a, b))).doesNotThrowAnyException();
    }

    @Test
    void 문자열을_십진수로_변환() {
        List<String> givenNumbers = List.of("100", "1", "123456", "78", "9", "-1", "1999999999", "-1999999999");
        List<Integer> expected = List.of(100, 1, 123456, 78, 9, -1, 1999999999, -1999999999);

        List<Integer> actual = new StringToNumberConverter(givenNumbers).convert();

        assertThat(actual).isEqualTo(expected);
    }
}