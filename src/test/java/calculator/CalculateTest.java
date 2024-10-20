package calculator;

import calculator.model.Calculate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateTest {

    @Test
    void sum_간단한_숫자_덧셈() {
        //given
        List<Long> numberList = List.of(1L, 2L, 3L);
        //when
        Calculate calculate = new Calculate(numberList);
        long result = calculate.sum();
        //then
        Assertions.assertEquals(result, 6);
    }

    @Test
    void sum_빈_배열_덧셈() {
        //given
        List<Long> numberList = List.of();
        //when
        Calculate calculate = new Calculate(numberList);
        long result = calculate.sum();
        //then
        Assertions.assertEquals(result, 0);
    }

    @Test
    void sum_오버플로우_수_연산_예외처리() {
        //given
        List<Long> numberList = List.of(Long.MAX_VALUE, 1L);
        //when
        Calculate calculate = new Calculate(numberList);
        //then
        Assertions.assertThrows(IllegalArgumentException.class, calculate::sum);
    }
}
