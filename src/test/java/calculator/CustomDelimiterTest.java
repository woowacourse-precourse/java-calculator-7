package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomDelimiterTest {
    private CustomDelimiter customDelimiter;
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        customDelimiter = new CustomDelimiter();
        calculator = new Calculator(customDelimiter);
    }

    @Test
    public void 커스텀만(){
        String input = "//;\\n1;2;3";
        int result = calculator.add(input);
        assertEquals(6, result);
    }

    @Test
    public void 기본_커스텀_혼합(){
        String input = "//|\\n1|2,3:4";
        int result = calculator.add(input);
        assertEquals(10, result);
    }

    @Test
    public void 커스텀_계산x(){
        String input = "//;\\n5";
        int result = calculator.add(input);
        assertEquals(5, result);
    }

    @Test
    public void 커스텀_빈문자열(){
        String input = "//&\\n";
        int result = calculator.add(input);
        assertEquals(0, result);
    }
}