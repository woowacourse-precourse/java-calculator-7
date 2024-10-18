package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSummerTest {

    @Test
    @DisplayName("배열 안의 숫자 합 계산")
    void 배열의_숫자_합_계산() {
        // given
        int[] numbers = {1, 2, 3, 4, 5};

        // when
        int total = NumberSummer.sum(numbers);

        // then
        assertThat(total).isEqualTo(15);
    }

    @Test
    @DisplayName("빈 배열일 경우 0 반환")
    void 빈_배열_합_계산() {
        // given
        int[] numbers = {};

        // when
        int total = NumberSummer.sum(numbers);

        // then
        assertThat(total).isEqualTo(0);
    }
}
