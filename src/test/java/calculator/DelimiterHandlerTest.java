package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

class DelimiterHandlerTest {

    @Test
    void 숫자만_계산한다() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("1");
        System.out.println("결과 : " + result);
        assertEquals(1, result);  // 1
    }

    @Test
    void 기본_구분자로_문자열을_계산한다2() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("1,2:3");  // 기본 구분자(, :)로 문자열 계산
        System.out.println("결과 : " + result);
        assertEquals(6, result);  // 1 + 2 + 3 = 6
    }

    @Test
    void 커스텀_구분자로_문자열을_계산한다() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("//;\n1;2;3");  // 커스텀 구분자(;)로 문자열 계산
        System.out.println("결과 : " + result);
        assertEquals(6, result);  // 1 + 2 + 3 = 6
    }

    @Test
    void 유효하지_않은_커스텀_구분자_입력시_예외가_발생한다() {
        StringCalculator calculator = new StringCalculator();
        assertThatThrownBy(() -> calculator.calculate("1;2;3"))  // 커스텀 구분자 형식이 아닌 경우
                .isInstanceOf(InvalidInputException.class)
                .hasMessage("유효하지 않은 구분자입니다.");
    }
}
