package calculator.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringToPositiveBigIntegerConverterTest {

    StringToPositiveBigIntegerConverter converter;

    @BeforeEach
    void before() {
        converter = new StringToPositiveBigIntegerConverter();
    }

    @Test
    void TDD_문자_양수_변환_실패() {
        //given
        String input = "test";

        //when
        assertThatThrownBy(() -> converter.convert(input)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TDD_문자_숫자_혼합_양수_변환_실패() {
        //given
        String input = "3123abcd\n";

        //when
        assertThatThrownBy(() -> converter.convert(input)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TDD_정수_양수_변환_실패() {
        //given
        String input = "0";

        //when
        assertThatThrownBy(() -> converter.convert(input)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자_양수_변환_성공() {
        //given
        String input = "123";

        //when
        BigInteger result = converter.convert(input);

        //then
        assertThat(result).isEqualTo(BigInteger.valueOf(123));
    }
}
