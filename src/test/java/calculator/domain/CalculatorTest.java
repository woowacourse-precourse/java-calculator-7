package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 숫자들을_더할_수_있다(){
        //given
        Calculator calculator = new Calculator();
        List<Number> numberList = List.of(new Number(1),new Number(2));

        //when
        Number number = calculator.addNumbers(numberList);

        //then
        assertThat(number.toString()).isEqualTo("3");
    }

    @Test
    void 계산결과를_응답한다(){
        //given
        Calculator calculator = new Calculator();
        List<Number> numberList = List.of(new Number(1),new Number(2));

        //when
        calculator.addNumbers(numberList);

        //then
        assertThat(calculator.showCurrentStatus()).isEqualTo("결과 : 3");
    }
}
