package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberTest {
    @ParameterizedTest
    @CsvSource(value = {"'1234 '", "' 1234'", "12 34", "''", "123a"})
    void 숫자가_아닌_경우_예외처리(String value) {
        assertThatThrownBy(() -> new Number(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_양수가_아닌_경우_예외처리() {
        assertThatThrownBy(() -> new Number("-1")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"+1234, 1234", "0, 0", "1234, 1234", "01234, 1234"})
    void 숫자가_들어온_경우(String input, String excepted) {
        //given
        //테스트 입력값이 @CsvSource를 통해 제공됨

        //when
        Number number = new Number(input);

        //then
        String result = number.getValue().toString();
        Assertions.assertThat(result).isEqualTo(excepted);
    }
}