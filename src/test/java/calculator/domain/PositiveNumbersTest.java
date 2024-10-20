package calculator.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
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
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}