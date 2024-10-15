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
    public void sumTest() {
        //given
        List<Integer> input = List.of(1, 2, 3);

        //when
        int result = sumCalculator.sum(input);

        //then
        assertThat(result).isEqualTo(6);
    }
}