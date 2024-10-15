package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {
    private int answer;
    @Test
    void 빈_문자열_처리(){
        CalculatorService cal = new CalculatorService();
        String input = "";
        answer = cal.returnAnswer(input);
        assertEquals(0, answer);
    }
}
