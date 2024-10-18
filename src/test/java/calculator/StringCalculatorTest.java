package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    void 빈_문자열_처리() {
        //given
        String input = "";

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 기본_구분자_덧셈() {
        //given
        String input = "1,2:3";

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_덧셈() {
        //given
        String input = "//;\\n1;2;3";

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 혼합_구분자_덧셈() {
        //given
        String input = "//;\\n1;2,3:4";

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(10);
    }

}