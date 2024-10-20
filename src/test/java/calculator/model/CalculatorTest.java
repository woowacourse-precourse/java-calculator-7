package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("덧셈 기능 테스트")
    public void addTest() {
        // given
        List<Long> numbers1 = Arrays.asList(1L);
        List<Long> numbers2 = Arrays.asList(100L, 300L);
        List<Long> numbers3 = Arrays.asList(100L, 300L, 1L);
        // when
        long result1 = calculator.add(numbers1);
        long result2 = calculator.add(numbers2);
        long result3 = calculator.add(numbers3);
        // then
        assertThat(result1).isEqualTo(1L);
        assertThat(result2).isEqualTo(400L);
        assertThat(result3).isEqualTo(401L);
    }
}
