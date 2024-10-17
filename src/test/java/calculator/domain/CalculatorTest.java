package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void 덧셈_테스트() {
        Calculator calculator = new Calculator();

        assertThat(calculator.sum(new String[]{"1", "2", "3", "4", "5", "6"})).isEqualTo(21);
    }

    @Test
    void 분리후_덧셈_테스트() {
        Separator sp = new Separator("//;\\n1,3;5:2;;");
        Calculator calculator = new Calculator();

        assertThat(calculator.sum(sp.cut())).isEqualTo(11);
    }
}
