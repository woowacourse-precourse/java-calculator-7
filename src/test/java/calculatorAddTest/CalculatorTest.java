package calculatorAddTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(); //테스트 메서드마다 실행 전 초기화
    }

    @Test
    void 빈_문자열_테스트() {
        assertEquals(0, calculator.sumFromString(""));
    }

    @Test
    void 기본_구분자_더하기_테스트() {
        assertEquals(13, calculator.sumFromString("1:2,10"));
    }

    @Test
    void 커스텀_구분자_더하기_테스트() {
        assertEquals(13, calculator.sumFromString("//;\\n1;2,10"));
        assertEquals(13, calculator.sumFromString("//;.!\\n1;.!2;.!10"));
        assertEquals(1, calculator.sumFromString("//;\\n1"));
    }

    @Test
    void 단일_문자_테스트() {
        assertEquals(1, calculator.sumFromString("1"));
    }
}
