package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void 합계_반환_테스트() {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);

        //when
        int sum = Calculator.sum(numbers);

        //then
        assertThat(sum).isEqualTo(10);
    }

    @Test
    void 빈_리스트_0_반환_테스트() {
        //given
        List<Integer> numbers = new ArrayList<>();

        //when
        int sum = Calculator.sum(numbers);

        //then
        assertThat(sum).isEqualTo(0);
    }
  
}