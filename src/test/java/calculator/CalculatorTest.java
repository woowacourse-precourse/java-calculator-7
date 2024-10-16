package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @BeforeEach
    void setUp() {
        Calculator calculator = new Calculator();
    }


    @Test
    void 계산하기(){
        String input="1,2,3"
        calculator.setInput(input);
        int result=calculator.add();
        assertEquals(6, result);
    }
}
