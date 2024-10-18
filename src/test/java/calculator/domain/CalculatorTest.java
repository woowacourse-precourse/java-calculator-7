package calculator.domain;


import calculator.domain.number.Numbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void 추출한_숫자열의_숫자를_더함() {
        //given
        Calculator calculator;
        Numbers numbers = new Numbers();
        numbers.addNumber("1");
        numbers.addNumber("2");

        //when
        calculator = new Calculator(numbers);

        //then
        Assertions.assertThat(calculator.getSum()).isEqualTo(3);
    }

}