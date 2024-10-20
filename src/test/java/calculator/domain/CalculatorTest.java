package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class CalculatorTest {

    @DisplayName("덧셈 중 오버플로우 발생 예외 테스트1")
    @Test
    void givenOverflow_whenAddition_thenThrowException1() throws Exception
    {
        // given
        Number a = new Number(Integer.MAX_VALUE);
        Number b = new Number(1);
        Calculator calculator = Calculator.getInstance();
        Operation operation = Addition.getInstance();

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(operation, a, b);
        });
        assertEquals("덧셈 중 오버플로우가 발생했습니다.", exception.getMessage());
    }

    @DisplayName("덧셈 중 오버플로우 발생 예외 테스트2")
    @Test
    void givenOverflow_whenAddition_thenThrowException2() throws Exception
    {
        // given
        Number a = new Number(1);
        Number b = new Number(Integer.MAX_VALUE);
        Calculator calculator = Calculator.getInstance();
        Operation operation = Addition.getInstance();

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(operation, a, b);
        });
        assertEquals("덧셈 중 오버플로우가 발생했습니다.", exception.getMessage());
    }

    @DisplayName("덧셈 계산기 테스트")
    @Test
    void givenCalculator_whenCalculate_thenDone() throws Exception
    {
        // given
        Number n1 = new Number(1);
        Number n2 = new Number(2);
        Number n3 = new Number(3);
        Calculator calculator = Calculator.getInstance();
        Operation operation = Addition.getInstance();

        Number expected = new Number(6);

        // when
        Number actual = calculator.calculate(operation, n1, n2, n3);

        // then
        assertEquals(expected, actual);
    }
}