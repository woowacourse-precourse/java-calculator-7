package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void 기본_구분자만_사용() {
        assertEquals(6, calculator.calculate("1,2:3"));
    }

    @Test
    void 커스텀_구분자만_사용() {
        assertEquals(6, calculator.calculate("//;\\n1;2;3"));
    }

    @Test
    void 기본과_커스텀_구분자_사용() {
        assertEquals(6, calculator.calculate("//;\\n1;2;3"));
    }

    @Test
    void 빈_문자열_입력_처리() {
        assertEquals(0, calculator.calculate(""));
    }

    @Test
    void 연속된_구분자_처리() {
        assertEquals(6, calculator.calculate("1,,2::3"));
    }

    @Test
    void 공백이_포함된_입력() {
        assertEquals(6, calculator.calculate(" 1 , 2 , 3 "));
    }

    @Test
    void 음수_입력_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1,-2,3"));
    }

    @Test
    void 유효하지_않은_숫자_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1,a,3"));
    }

    @Test
    void 유효하지_않은_구분자_형식_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("//\\n1;2;3"));
    }

}