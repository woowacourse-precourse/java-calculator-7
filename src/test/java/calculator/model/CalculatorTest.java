package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 계산기_생성() {
        Calculator calculator = new Calculator();

        Assertions.assertThat(calculator).isNotNull();
    }

    /**
     *  변환 된 계산식만 들어옴
     */
    @Test
    void 계산_테스트() {
        Calculator calculator = new Calculator();

        int testResult1 = calculator.run("5+2+3+4");
        int testResult2 = calculator.run("1");
        int testResult3 = calculator.run("5+2");

        Assertions.assertThat(testResult1).isEqualTo(14);
        Assertions.assertThat(testResult2).isEqualTo(1);
        Assertions.assertThat(testResult3).isEqualTo(7);
    }
}
