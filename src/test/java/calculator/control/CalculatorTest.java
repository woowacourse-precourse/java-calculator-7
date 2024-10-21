package calculator.control;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    @DisplayName("구분된 문자열 추출")
    public void addNumbersTest() {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        int expect = 9;
        //when
        Calculator calculator = new Calculator();
        //then
        assertEquals(calculator.addNumbers(numbers), expect);
    }
}
