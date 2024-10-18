package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("구분자를_고려하여_입력_문자열_내_숫자의_합을_반환한다")
    public void calculate() {
        //given
        StringCalculator calculator = new StringCalculator();
        String input1 = "14";
        String input2 = "1,4:7";
        String input3 = "1,:4:7";
        String input4 = "//d\\n1d8,4:7";
        String input5 = "//8\\n1847";
        String input6 = "";
        String input7 = ":";
        String input8 = "//t\\n";

        //when
        int result1 = calculator.calculate(input1);
        int result2 = calculator.calculate(input2);
        int result3 = calculator.calculate(input3);
        int result4 = calculator.calculate(input4);
        int result5 = calculator.calculate(input5);
        int result6 = calculator.calculate(input6);
        int result7 = calculator.calculate(input7);
        int result8 = calculator.calculate(input8);

        //then
        assertThat(result1).isEqualTo(14);
        assertThat(result2).isEqualTo(12);
        assertThat(result3).isEqualTo(12);
        assertThat(result4).isEqualTo(20);
        assertThat(result5).isEqualTo(48);
        assertThat(result6).isEqualTo(0);
        assertThat(result7).isEqualTo(0);
        assertThat(result8).isEqualTo(0);
    }
}