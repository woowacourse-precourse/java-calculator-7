package calculator;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorFactoryTest {

    @Test
    @DisplayName("커스텀지정 구분자가 포함된 문자열이 주어졌을때, 해당 구분자를 기준으로 숫자로 변경된 Array가 반환된다.")
    void splitStringToNumbers() {
        //given
        String inputStr = "//;\\n1;2;3";
        CalculatorFactory calculatorFactory = new CalculatorFactory();
        //when
        int[] numberArray = calculatorFactory.splitStringToNumbers(inputStr);
        //then
        Assertions.assertThat(numberArray[0]).isEqualTo(1);
        System.out.println(Arrays.toString(numberArray));
    }

}