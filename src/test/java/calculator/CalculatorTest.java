package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.delimiter.handler.factory.DelimiterHandlerFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculatorTest {
    private DelimiterHandlerFactory factory = new DelimiterHandlerFactory();
    private Calculator calculator = new Calculator(factory);

    @Test
    @DisplayName("문자열을 받아 계산값을 반환한다.")
    void calculate_sum_with_string() {
        String s = "1,2:3,4";

        int sum = calculator.sum(s);

        Assertions.assertThat(sum).isEqualTo(10);
    }

    @Test
    void test1() {
        String s1 = "//;\\n1;2;3";
        String s2 = "//7\\n47576";
        String s3 = "//-\\n4-5-6";
        String s4 = "// \\n4 5 6";
        String s5 = "//||\\n7";

        // then
        assertThat(calculator.sum(s1)).isEqualTo(6);
        assertThat(calculator.sum(s2)).isEqualTo(15);
        assertThat(calculator.sum(s3)).isEqualTo(15);
        assertThat(calculator.sum(s4)).isEqualTo(15);
        assertThat(calculator.sum(s5)).isEqualTo(7);
    }
}
