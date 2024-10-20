package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberUtilsTest {

    @DisplayName("리스트의 숫자들을 모두 더해주는 메서드를 테스트하라")
    @Test
    void test_sum() {
        List<Integer> numbers = List.of(1, 2, 3, 4);

        int result = NumberUtils.sum(numbers);

        assertThat(result).isEqualTo(10);
    }

    @DisplayName("계산식을 구분자로 나누어 숫자들을 분리하는 메서드를 테스트하라")
    @Test
    void test_splitNumbers() {
        DelimiterAndNumber delimiterAndNumber = new DelimiterAndNumber(";", "1;2;3");

        List<Integer> numbers = NumberUtils.splitNumbers(delimiterAndNumber);

        assertThat(numbers).isEqualTo(List.of(1,2,3));
    }
}
