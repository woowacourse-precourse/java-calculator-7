package calculator;


import exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import separator.CustomSeparator;
import separator.CustomSeparatorFormat;
import separator.Separator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

class CalculatorTest {
    @DisplayName("String값을 숫자로 변환하여 더할 수 있다.")
    @Test
    void getSum(){
    //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "//@!\\n1@!2@!3";
        CustomSeparator customSeparator = new CustomSeparator(inputData, List.of("@!"),customSeparatorFormat);
        Calculator calculator =new Calculator(customSeparator);
        //when

        BigInteger sum = calculator.getSum(customSeparator.splitInputDataBySeparator());

        //then
        Assertions.assertThat(sum).isEqualTo(6);
    }

    @DisplayName("String값에 숫자가 아닌 다른 값이 들어오면 에러를 반환한다.")
    @Test
    void getSumException(){
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "//@!\\n1@!r@!3";
        CustomSeparator customSeparator = new CustomSeparator(inputData, List.of("@!"),customSeparatorFormat);
        Calculator calculator =new Calculator(customSeparator);
        //when

        //then
        Assertions.assertThatThrownBy(()->calculator.getSum(customSeparator.splitInputDataBySeparator())).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ONLY_NUMBERS_ALLOWED_EXCEPT_SEPARATOR.getMessage());
    }

    @DisplayName("숫자가 아닌 빈값이 들어가면 0을 반환한다.")
    @Test
    void shouldReturnZeroWhenInputIsEmpty(){
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "// \\n1 2 3";
        CustomSeparator customSeparator = new CustomSeparator(inputData, List.of(" "),customSeparatorFormat);
        Calculator calculator =new Calculator(customSeparator);
        //when
        String emptyString = calculator.isEmptyString(" ");
        //then
        Assertions.assertThat(emptyString).isEqualTo("0");
    }

    @DisplayName("음수가 들어가면 에러 반환한다.")
    @Test
    void validateNegativeValue(){
        //given
        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "1,-2,3";
        CustomSeparator customSeparator = new CustomSeparator(inputData, List.of(",",":"),customSeparatorFormat);
        Calculator calculator =new Calculator(customSeparator);
        BigInteger bigInteger = new BigInteger("-2");
        BigInteger bigInteger2 = new BigInteger("1");

        //when
        boolean b = calculator.validateNegativeValue(bigInteger2);
        //then
        Assertions.assertThatThrownBy(()->
                calculator.validateNegativeValue(bigInteger)).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThat(b).isFalse();
    }

}