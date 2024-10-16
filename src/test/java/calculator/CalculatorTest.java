package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        Delimiter delimiter = new BasicDelimiter();
        calculator = new Calculator(delimiter);
    }

    @Test
    public void 빈문자열(){
        String input = "";
        int result = calculator.add(input);
        assertEquals(0, result);
    }

    @Test
    public void 콤마(){
        String input = "1,2,3";
        int result = calculator.add(input);
        assertEquals(6, result);
    }

    @Test
    public void 콜론_콤마_혼합(){
        String input = "1,2:3";
        int result = calculator.add(input);
        assertEquals(6, result);
    }

    @Test
    public void 구분자_사이_빈문자열(){
        String input = "1::2";
        int result = calculator.add(input);
        assertEquals(3, result);
    }
}