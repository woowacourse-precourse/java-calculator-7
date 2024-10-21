package calculator;

import calculator.model.InputProcessor;
import calculator.model.DelimiterCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void 기본_구분자_쉼표와_콜론으로_계산() {
        InputProcessor inputProcessor = new InputProcessor("1,2:3");
        DelimiterCalculator calculator = new DelimiterCalculator(inputProcessor);
        assertEquals(6, calculator.getResult());
    }

    @Test
    void 빈_문자열_입력() {
        InputProcessor inputProcessor = new InputProcessor("");
        DelimiterCalculator calculator = new DelimiterCalculator(inputProcessor);
        assertEquals(0, calculator.getResult());
    }

    @Test
    void 커스텀_구분자_세미콜론으로_계산() {
        InputProcessor inputProcessor = new InputProcessor("//;\\n1;2;3");
        DelimiterCalculator calculator = new DelimiterCalculator(inputProcessor);
        assertEquals(6, calculator.getResult());
    }

    @Test
    void 입력값_음수_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new InputProcessor("1,-2:3"));
    }

    @Test
    void 연속된_구분자_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new InputProcessor("1,,2:3"));
    }

    @Test
    void 숫자와_구분자_아닌_값_입력시_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new InputProcessor("1,a:3"));
    }

    @Test
    void 커스텀_구분자_문자_입력() {
        InputProcessor inputProcessor = new InputProcessor("//x\\n1x2x3");
        DelimiterCalculator calculator = new DelimiterCalculator(inputProcessor);
        assertEquals(6, calculator.getResult());
    }
}
