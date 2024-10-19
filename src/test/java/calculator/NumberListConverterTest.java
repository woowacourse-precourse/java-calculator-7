package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 숫자가_아닌_값이_포함되어_있으면_예외가_발생한다() {
        // given
        String[] values = {"1", "2", "a"};

        // when & then
        assertThatThrownBy(() -> NumberListConverter.toNumbers(values))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
    }
}
