package calculator.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateServiceTest {
    private static CalculateService calculateService;

    @BeforeAll
    static void setUp() {
        calculateService = new CalculateService();
    }

    @Test
    @DisplayName("정수의 합을 구하는 데 성공한다.")
    void sum() {
        // given
        List<Integer> numbers = List.of(1, 2, 3);
        int expected = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        // when
        int real = calculateService.sum(numbers);

        // then
        assertThat(real).isEqualTo(expected);
    }
}