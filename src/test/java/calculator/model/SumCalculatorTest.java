package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SumCalculatorTest {

    SumCalculator sumCalculator = new SumCalculator();

    @Test
    @DisplayName("list 합계 구하기 테스트")
    public void calculateTest() {
        //given
        List<Integer> input1 = List.of(1, 2, 3);
        List<Integer> input2 = List.of(0, 0);

        //when
        int result1 = sumCalculator.calculate(input1);
        int result2 = sumCalculator.calculate(input2);

        //then
        assertThat(result1).isEqualTo(6);
        assertThat(result2).isEqualTo(0);
    }
}