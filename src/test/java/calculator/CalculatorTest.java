package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    void 빈_문자열_입력() {
        //given
        String input = "";

        //when
        Calculator calculator = new Calculator();
        int result = calculator.run(input);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 기본_구분자_쉼표_사용() {
        //given
        String input = "1,3,5";

        //when
        Calculator calculator = new Calculator();
        int result = calculator.run(input);

        //then
        assertThat(result).isEqualTo(9);
    }

    @Test
    void 기본_구분자_콜론_사용() {
        //given
        String input = "1:3:5";

        //when
        Calculator calculator = new Calculator();
        int result = calculator.run(input);

        //then
        assertThat(result).isEqualTo(9);
    }

    @Test
    void 기본_구분자_혼합_사용() {
        //given
        String input = "1,3:5";

        //when
        Calculator calculator = new Calculator();
        int result = calculator.run(input);

        //then
        assertThat(result).isEqualTo(9);
    }

    @Test
    void 커스텀_구분자_두개_이상_숫자_입력() {
        //given
        String input = "//!\\n1!3!5";

        //when
        Calculator calculator = new Calculator();
        int result = calculator.run(input);

        //then
        assertThat(result).isEqualTo(9);
    }

    @Test
    void 잘못된_커스텀_구분자_사용_예외발생() {
        //given
        String input = "//;\\n1!3!5";

        //when
        //then
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.run(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}