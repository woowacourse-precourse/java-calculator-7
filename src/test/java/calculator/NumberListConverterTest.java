package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class NumberListConverterTest {

    @Test
    void 문자열_리스트를_숫자_리스트로_변환한다() {
        // given
        String[] values = {"1", "2", "3"};

        // when
        List<PositiveNumber> numbers = NumberListConverter.toNumbers(values);

        // then
        assertThat(numbers).containsExactly(new PositiveNumber(1), new PositiveNumber(2), new PositiveNumber(3));
    }
}
