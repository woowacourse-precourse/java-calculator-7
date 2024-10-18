package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();
    @Test
    void inputEmptyString() {
        assertEquals(0, calculator.calculate(""));
    }
    @Test
    void inputDefaultDelimiter() {
        //given
        String case1 = "1,2:3";
        String case2 = "1,2,3";
        String case3 = "1:2:3";
        String case4 = "1:2:3:3:3:3";
        //when
        int result1 = calculator.calculate(case1);
        int result2 = calculator.calculate(case2);
        int result3 = calculator.calculate(case3);
        int result4 = calculator.calculate(case4);
        //then
        assertEquals(6, result1);
        assertEquals(6, result2);
        assertEquals(6, result3);
        assertEquals(15, result4);
    }
    @Test
    void inputSingleCharacterDelimiter() {
        // given
        String case1 = "//;\\n1;2;3";

        // when
        int result = calculator.calculate(case1);

        // then
        assertEquals(6, result); // 1 + 2 + 3 = 6
    }

    @Test
    void inputMultipleCharacterDelimiter() {
        // given
        String case2 = "//;;\\n10;;20;;30";

        // when
        int result = calculator.calculate(case2);

        // then
        assertEquals(60, result); // 10 + 20 + 30 = 60
    }

    @Test
    void inputSpecialCharacterDelimiter() {
        // given
        String case3 = "//|\\n5|10|15";

        // when
        int result = calculator.calculate(case3);

        // then
        assertEquals(30, result); // 5 + 10 + 15 = 30
    }

    @Test
    void inputAlphabetDelimiter() {
        // given
        String case4 = "//abc\\n1abc2abc3";

        // when
        int result = calculator.calculate(case4);

        // then
        assertEquals(6, result); // 1 + 2 + 3 = 6
    }

    @Test
    void inputMixedCharacterDelimiter() {
        // given
        String case5 = "//$@\\n7$@8$@9";

        // when
        int result = calculator.calculate(case5);

        // then
        assertEquals(24, result); // 7 + 8 + 9 = 24
    }
    @Test
    void inputDefaultDelimiter_negative() {
        //given
        String input = "-1,2,3";
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(input));
    }

    @Test
    void input_십의자리이상_덧셈() {
        //given
        String case1 = "10,20:30";
        String case2 = "101,202:303";
        String case3 = "1011,2022:3033";
        //when
        int result1 = calculator.calculate(case1);
        int result2 = calculator.calculate(case2);
        int result3 = calculator.calculate(case3);
        //then
        assertEquals(60, result1);
        assertEquals(606, result2);
        assertEquals(6066, result3);
    }
}