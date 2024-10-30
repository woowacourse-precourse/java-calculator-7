package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.delimiter.handler.factory.DelimiterHandlerFactory;
import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculatorTest {
    private DelimiterHandlerFactory factory = new DelimiterHandlerFactory();
    private Calculator calculator = new Calculator(factory);

    @Test
    @DisplayName("문자열을 받아 계산값을 반환한다.")
    void calculate_sum_with_string() {
        String s1 = "1,2:3,4";
        String s2 = "111,222:333,444";
        String s3 = "//$\\n123415$2$3$4";
        String s4 = "//$\\n123456789";
        String s5 = "//$\\n";
        String s6 = "//;\\n1;2;3";
        String s7 = "//7\\n47576";
        String s8 = "//-\\n4-5-6";
        String s9 = "// \\n4 5 6";
        String s10 = "//|\\n7";
        String s11 = "//\\\\n7\\8";

        assertThat(calculator.sum(s1)).isEqualTo(10);
        assertThat(calculator.sum(s2)).isEqualTo(1110);
        assertThat(calculator.sum(s3)).isEqualTo(123424);
        assertThat(calculator.sum(s4)).isEqualTo(123456789);
        assertThat(calculator.sum(s5)).isEqualTo(0);
        assertThat(calculator.sum(s6)).isEqualTo(6);
        assertThat(calculator.sum(s7)).isEqualTo(15);
        assertThat(calculator.sum(s8)).isEqualTo(15);
        assertThat(calculator.sum(s9)).isEqualTo(15);
        assertThat(calculator.sum(s10)).isEqualTo(7);
        assertThat(calculator.sum(s11)).isEqualTo(15);
    }

    @Test
    @DisplayName("int형 범위를 넘어가는 문자열의 합을 구할 수 있다..")
    void calculate_sum_with_over_integer() {
        List<String> list = List.of("123456789012345678901234567890", "9");

        BigInteger ret = list.stream()
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO, BigInteger::add);

        assertThat(ret).isEqualTo(new BigInteger("123456789012345678901234567899"));
    }
}
