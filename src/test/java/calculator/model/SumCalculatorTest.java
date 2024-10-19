package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("덧셈 계산 테스트")
class SumCalculatorTest {
    private SumCalculator sumCalculator;

    @BeforeEach
    void setUp() {
        sumCalculator = new SumCalculator();
    }

    @Test
    @DisplayName("덧셈 연산을 정확하게 수행한다")
    void calculateSumExactly(){
        assertThat(sumCalculator.calculate(new Arithmetic("1,2,3,4"))).isEqualTo(10);
    }
}