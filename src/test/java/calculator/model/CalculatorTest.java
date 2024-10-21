package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("계산기 테스트")
    void calculatorTest() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
        int expectedResult = 60;
        int result = Calculator.operate(numbers);

        assertEquals(result, expectedResult);
    }

    @Test
    @DisplayName("int 범위 초과 테스트")
    void overIntegerTest() {
        List<Integer> numbers = new ArrayList<>(List.of(2000000000, 1000000000, 30));

        assertThrows(IllegalArgumentException.class, () -> Calculator.operate(numbers));
    }

    @Test
    @DisplayName("하나의 입력 값 테스트")
    void calculateOneTest() {
        List<Integer> numbers = new ArrayList<>(List.of(10));
        int expectedResult = 10;
        int result = Calculator.operate(numbers);

        assertEquals(result, expectedResult);
    }

}
