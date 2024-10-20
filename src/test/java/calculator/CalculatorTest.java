package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    /*
    테스트시 주의 사항
    입력의 경우 \n을 그대로 받아들이지만 코드에서 입력시 escape가 발생하므로 \로 처리해줘야 한다.
     */
    @Test
    void calculateTest() {
        int result1 = Calculator.calculate("");
        int result2 = Calculator.calculate("1");
        int result3 = Calculator.calculate("1:2,3");
        int result4 = Calculator.calculate("//;\\n1;2;3");
        int result5 = Calculator.calculate("//;\\n1;2,4");
        int result6 = Calculator.calculate("13,25");
        int result7 = Calculator.calculate("//;\\n");

        Assertions.assertThat(result1).isEqualTo(0);
        Assertions.assertThat(result2).isEqualTo(1);
        Assertions.assertThat(result3).isEqualTo(6);
        Assertions.assertThat(result4).isEqualTo(6);
        Assertions.assertThat(result5).isEqualTo(7);
        Assertions.assertThat(result6).isEqualTo(38);
        Assertions.assertThat(result7).isEqualTo(0);
    }

    @Test
    void illegalInputTest() {
        // 구분자로 양수를 사용하려는 경우
        Assertions.assertThatThrownBy(()->Calculator.calculate("//6\\n"))
                .isInstanceOf(IllegalArgumentException.class);
        // 커스텀 구분자를 등록하지 않고 사용하력는 경우
        Assertions.assertThatThrownBy(()->Calculator.calculate("1;2,3"))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(()->Calculator.calculate(";//;\\n1;2,3"))
                .isInstanceOf(IllegalArgumentException.class);
        // 커스텀 구분자로 문자가 아닌 문자열을 사용하려는 경우
        Assertions.assertThatThrownBy(()->Calculator.calculate("//;=\n1;=3"))
                .isInstanceOf(IllegalArgumentException.class);
        // 구분자, 양수로 시작하지 않는 문자열이 길이가 짧은 경우
        Assertions.assertThatThrownBy(()->Calculator.calculate("//"))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
