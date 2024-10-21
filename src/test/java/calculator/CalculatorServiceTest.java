package calculator;

import calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @Test
    void testAddWithComma() {
        CalculatorService service = new CalculatorService();
        assertEquals(6, service.add("1,2,3"));
    }

    @Test
    void testAddWithColon() {
        CalculatorService service = new CalculatorService();
        assertEquals(6, service.add("1:2:3"));
    }

    @Test
    void testAddWithCustomDelimiter() {
        CalculatorService service = new CalculatorService();
        int result = service.add("//;\n1;2;3");  // ';' 구분자를 사용한 입력
        assertEquals(6, result);  // 예상 결과는 1 + 2 + 3 = 6
    }


    @Test
    void testAddWithEmptyString() {
        CalculatorService service = new CalculatorService();
        assertEquals(0, service.add(""));
    }

    @Test
    void testAddWithNegativeNumber() {
        CalculatorService service = new CalculatorService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.add("1,-2,3");  // 음수가 포함된 입력
        });
    }
}

