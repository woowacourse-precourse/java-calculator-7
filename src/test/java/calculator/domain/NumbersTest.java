package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class NumbersTest {

    private Numbers numbers;

    @BeforeEach
    void setUp() {
        numbers = new Numbers();
    }

    @Test
    @DisplayName("빈 숫자 리스트의 합은 0이어야 한다.")
    void sumOfEmptyListShouldBeZero() {
        assertThat(numbers.getSum())
                .as("빈 리스트의 합은 0이어야 합니다.")
                .isZero();
    }

    @Test
    @DisplayName("숫자를 추가한 후의 합을 정확히 계산해야 한다.")
    void shouldCalculateSumCorrectly() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        assertThat(numbers.getSum())
                .as("1, 2, 3을 더한 값은 6이어야 합니다.")
                .isEqualTo(6);
    }

    @Test
    @DisplayName("숫자를 여러 번 추가한 후의 합을 정확히 계산해야 한다.")
    void shouldAccumulateSumWithMultipleAdds() {
        numbers.add(10);
        assertThat(numbers.getSum())
                .isEqualTo(10);

        numbers.add(5);
        assertThat(numbers.getSum())
                .isEqualTo(15);

        numbers.add(5);
        assertThat(numbers.getSum())
                .isEqualTo(20);
    }
}
