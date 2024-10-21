package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    @DisplayName("주어진 숫자들의 합을 반환")
    void test() {
        // given
        Numbers numbers = new Numbers();
        numbers.setNumbers(new int[]{1, 2, 3});

        // when
        int actual = numbers.sum();

        // then
        assertThat(actual).isEqualTo(6);
    }
}
