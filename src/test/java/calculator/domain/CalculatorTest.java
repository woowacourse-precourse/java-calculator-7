package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @BeforeEach
    void setUp(){
        SeperatorFactory.resetSeperatorRegex();
    }

    @Test
    void 커스텀구분자_있을때_문자열_계산(){
        String input="//!\\n23!:3";

        assertThat(Calculator.inputCalculate(input)).isEqualTo(26);
    }

    @Test
    void 커스텀구분자가_없을경우_문자열_계산(){
        String input="23:3,";

        assertThat(Calculator.inputCalculate(input)).isEqualTo(26);
    }

    @Test
    void 공백을_입력했을때_0_반환(){
        String input="";

        assertThat(Calculator.inputCalculate(input)).isEqualTo(0);

    }

    @Test
    void 공백이_구분자일떄_문자열_계산(){
        String input="// \\n2 3 4";

        assertThat(Calculator.inputCalculate(input)).isEqualTo(9);
    }

    @Test
    void 덧셈이_오버플로우일때_예외_발생(){
        String input="1111111111:1111111111";
        String OVERFLOW_RESULT="덧셈의 결과가 int 범위를 넘어갔습니다";

        assertThatThrownBy(()->Calculator.inputCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OVERFLOW_RESULT);
    }

    @Test
    void 특정_수가_오버플로우일때_예외_발생(){
        String input=String.valueOf(Long.MAX_VALUE);
        String OVERFLOW_NUMBER="특정 수가 int 범위를 넘어갔습니다";

        assertThatThrownBy(()->Calculator.inputCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OVERFLOW_NUMBER);
    }

    @Test
    void 커스텀_구분자가_아닐때_예외_발생(){
        String input="//~\\n1!2";
        String INVALID_SEPERATOR="커스텀 구분자가 아닌 기호를 입력했습니다";

        assertThatThrownBy(()->Calculator.inputCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_SEPERATOR);
    }

}