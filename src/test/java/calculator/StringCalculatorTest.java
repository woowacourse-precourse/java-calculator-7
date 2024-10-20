package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    void 빈_문자열_입력시_예외가_발생한다() {
        StringCalculator calculator = new StringCalculator();
        assertThatThrownBy(() -> calculator.calculate(""))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("입력값이 없습니다.");
    }

    @Test
    void 쉼표와_콜론을_구분자로_숫자의_합을_반환한다() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("1,2:3");
        System.out.println("결과 : " + result);
        assertEquals(6, result);
    }

    @Test
    void 커스텀_구분자로_숫자의_합을_반환한다() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("//;\n1;2;3");
        System.out.println("결과 : " + result);
        assertEquals(6, result);
    }

    @Test
    void 음수_입력시_예외가_발생한다() {
        StringCalculator calculator = new StringCalculator();
        assertThatThrownBy(() -> calculator.calculate("1,-2,3"))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("음수는 허용되지 않습니다.");
    }

    @Test
    void 유효하지_않은_숫자_입력시_예외가_발생한다() {
        StringCalculator calculator = new StringCalculator();
        assertThatThrownBy(() -> calculator.calculate("1,a,3"))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("잘못된 입력입니다.");
    }

    @Test
    void 구분자_없이_문자열_입력시_예외가_발생한다() {
        StringCalculator calculator = new StringCalculator();
        assertThatThrownBy(() -> calculator.calculate("1;2;3"))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("잘못된 입력입니다.");
    }
}
