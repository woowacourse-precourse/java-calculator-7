package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveNumbersTest {

    @Test
    @DisplayName("숫자 합 계산 성공 테스트")
    void testPositiveNumbersSuccess() {
        // given
        List<String> numbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);
        int expected = 55;

        // when
        int actual = positiveNumbers.calculateSum();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자 합 계산 integer 범위 초과 테스트")
    void testPositiveNumbersFail() {
        // given
        List<String> numbers = List.of("2147483647", "2147483647");
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);

        // when then
        assertThatThrownBy(positiveNumbers::calculateSum)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
