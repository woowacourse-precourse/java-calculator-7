package calculator.domain;

import calculator.exception.InvalidInputException;
import calculator.validation.MessageType;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

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
    void 존재하지_않는_커스텀구분자_예외_발생(){
        String input="//!\\n1:~2";

        assertThatThrownBy(()->Calculator.inputCalculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageType.INVALID_SEPERATOR.getMessage());
    }

    @Test
    void 숫자가_구분자일때_예외_발생() throws Exception{
        String input="//3\\n12";

        assertThatThrownBy(()->Calculator.inputCalculate(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(MessageType.NUMBER_SEPERATOR.getMessage());
    }

    @Test
    void 마이너스가_구분자일때_예외_발생(){
        String input="//-\\n-3";

        assertThatThrownBy(()->Calculator.inputCalculate(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(MessageType.MINUS_SEPERATOR.getMessage());

    }

    @Test
    void 음수를_입력했을때_예외_발생(){
        String input="//!\\n-34";

        assertThatThrownBy(()->Calculator.inputCalculate(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(MessageType.NEGATIVE_INPUT.getMessage());

    }
}