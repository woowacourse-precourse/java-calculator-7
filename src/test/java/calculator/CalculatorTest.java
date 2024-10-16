package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator("1,2,3");
    }


    @Test
    void 계산하기() {
        int result = calculator.add();
        assertEquals(6, result);
    }
}
