package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    @DisplayName("StringCalculator는_입력_문자열_내_숫자의_합을_반환할_수_있다")
    public void calculate() {
        //given
        StringCalculator calculator = new StringCalculator();
        InputString inputString = new InputString("//;\\n3:4,4;19");

        //when
        int result = calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(30);
    }
}