package calculator.calculator;

import static org.junit.jupiter.api.Assertions.*;

import calculator.mock.FakeStringParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringAdditionCalculatorTest {
    private StringAdditionCalculator stringAdditionCalculator;

    @BeforeEach
    void setUp() {
        stringAdditionCalculator = new StringAdditionCalculator();
        stringAdditionCalculator.setParser(new FakeStringParser());
    }

    @Test
    void 입력받은_문자열을_덧셈_연산한다() {
        Long result = stringAdditionCalculator.calculate("1,2,4");
        assertEquals(7L, result);

        Long result2 = stringAdditionCalculator.calculate("1:2:8");
        assertEquals(11L, result2);

        Long result3 = stringAdditionCalculator.calculate("//;\\n1;2;3");
        assertEquals(6L, result3);

        Long result4 = stringAdditionCalculator.calculate("");
        assertEquals(0L, result4);
    }
}