package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.command.SumCommand;
import calculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    private final CalculatorService calculator = new CalculatorService();

    @BeforeEach
    void setUp() {
        calculator.setCommand(new SumCommand());
    }

    @Test
    void 빈_문자열_처리_테스트() {
        assertEquals(0, calculator.calculate(""));
    }

    @Test
    void 기본_구분자_처리_테스트() {
        assertEquals(6, calculator.calculate("1,2:3"));
    }

    @Test
    void 커스텀_구분자_처리_테스트() {
        assertEquals(6, calculator.calculate("//#\\n1#2#3"));
    }

    @Test
    void 긴_커스텀_구분자_처리_테스트() {
        assertEquals(6, calculator.calculate("//qq\\n1qq2qq3"));
    }


    @Test
    void 기본_커스텀_구분자_처리_테스트() {
        assertEquals(6, calculator.calculate("//#\\n1#2:3"));
    }

    @Test
    void 여러개의_커스텀_구분자_처리_테스트() {
        assertEquals(6, calculator.calculate("//#\\n//$\\n1#2$3"));
    }

    @Test
    void 음수_입력_예외_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1,-2,3"));
        assertEquals("음수 입력은 불가능합니다: -2", exception.getMessage());
    }

    @Test
    void 숫자가_아닌_예외_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1,a,3"));
        assertEquals("올바르지 않은 형식입니다: a", exception.getMessage());
    }
}