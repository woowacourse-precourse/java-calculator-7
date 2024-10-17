package calculator.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringToBigIntegerConverterTest {

    StringToBigIntegerConverter converter;

    @BeforeEach
    void before() {
        converter = new StringToBigIntegerConverter();
    }

    @Test
    void TDD_문자열_숫자_변환_실패() {
        //given
        String input = "test";

        //when
        assertThatThrownBy(() -> converter.convert(input)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_숫자_변환_성공() {
        //given
        String input = "123";

        //when
        BigInteger result = converter.convert(input);

        //then
        assertThat(result).isEqualTo(BigInteger.valueOf(123));
    }

    @Test
    void TDD_문자열_숫자_변환_실패시_예외처리() {
        //given
        String input = "3123\n";

        //when
        assertThatThrownBy(() -> converter.convert(input)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TDD_문자열_양수_아닐시_예외처리() {
        //given
        String input = "0";

        //when
        assertThatThrownBy(() -> converter.convert(input)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
