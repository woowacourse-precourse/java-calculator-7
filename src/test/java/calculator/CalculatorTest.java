package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest{

    @Test
    void 커스텀_구분자가_1글자가_아닐_경우_예외_발생(){
        //given
        String testInputString = "//-=-\\n123";

        //when
        Throwable input = catchThrowable(() -> {
            new Calculator(testInputString);
        });

        //then
        assertThat(input).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_대신_문자가_들어올_경우_예외_발생(){
        //given
        String testInputString = "1:a,b:3";

        //when
        Throwable input = catchThrowable(() -> {
            new Calculator(testInputString);
        });

        //then
        assertThat(input).isInstanceOf(IllegalArgumentException.class);
    }

}
