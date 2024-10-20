package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.Calculator;
import calculator.service.StringSeparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;
    private StringSeparator stringSeparator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        stringSeparator = new StringSeparator(calculator);
    }

    @Test
    void 기본_구분자_테스트() {
        stringSeparator.extractAndProcessSeparators("1,2:3");
        assertEquals(6, calculator.getSumNumbers());
    }

    @Test
    void 커스텀_구분자_테스트() {
        stringSeparator.extractAndProcessSeparators("//;\\n1;2;3");
        assertEquals(6, calculator.getSumNumbers());
    }

    @Test
    void 음수_예외처리_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            stringSeparator.extractAndProcessSeparators("1,-2,3");
        });
        assertEquals("음수는 허용되지 않습니다: -2", exception.getMessage());
    }

    @Test
    void 잘못된_입력_예외처리_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            stringSeparator.extractAndProcessSeparators("//;\\n1;2;m");
        });
        assertEquals("잘못된 입력입니다.", exception.getMessage());
    }
}
