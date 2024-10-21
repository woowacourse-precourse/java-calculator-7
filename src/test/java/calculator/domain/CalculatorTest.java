package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("sum() 메서드 테스트")
    void sum() {
        // given
        SumCalculator calculator = new SumCalculator();
        List<Integer> data = List.of(1, 2, 3, 4, 5);

        // when
        int result = calculator.calculate(data);

        // then
        assertEquals(15, result);
    }
}
