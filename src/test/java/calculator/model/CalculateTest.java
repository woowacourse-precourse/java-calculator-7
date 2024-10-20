package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CalculateTest {

    @Test
    void sumOfNumbers() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        //when
        Calculate calculate = new Calculate();
        int result = calculate.sumOfNumbers(numbers);

        //then
        assertEquals(45, result);
    }
}