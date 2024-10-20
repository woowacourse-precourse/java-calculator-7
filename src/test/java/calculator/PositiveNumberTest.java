package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;

class PositiveNumberTest {

    @Test
    void 음수인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new PositiveNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음수는 입력할 수 없습니다.");
    }

    @Test
    void 두_수를_더한다() {
        assertThat(new PositiveNumber(1).add(new PositiveNumber(2))).isEqualTo(new PositiveNumber(3));
    }

    @Test
    void 모든_수의_합을_구한다() {
        // given
        List<PositiveNumber> numbers = NumberListConverter.toNumbers(
                new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});

        // when
        PositiveNumber result = PositiveNumber.sum(numbers);

        // then
        assertThat(result).isEqualTo(new PositiveNumber(55));
    }
}
